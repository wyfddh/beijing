package com.tj720.admin.dao.es;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.apache.commons.collections.CollectionUtils;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsResponse;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingResponse;
import org.elasticsearch.action.admin.indices.open.OpenIndexAction;
import org.elasticsearch.action.admin.indices.open.OpenIndexRequestBuilder;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.StringUtil;
import com.tj720.admin.model.ESModel;
import com.tj720.admin.model.ESColumnModel;
import com.tj720.mip.springbeans.Config;
import com.tj720.mip.utils.Page;

@Repository("esSearchDao")
public class EsSearchDao {

	private static Logger logger = LoggerFactory.getLogger(EsSearchDao.class);
	@Autowired
	private Config config;
	
	private static Client client;
	
	@Autowired
	public void init(){
		if(client != null)
			return;
		
		if(config.getEsNodeIpInfo().trim().equals("")){
			try {
				client = TransportClient.builder().build().addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(config.getEsHost()), config.getEsPort()));
			} catch (UnknownHostException e) {
				logger.error(e.getLocalizedMessage());
				e.printStackTrace();
			}
		}else{
			client = clusterClient(config.getEsClusterName(),config.getEsNodeIpInfo());
		}
	}
	/**
	 * 批量添加
	 */
	public boolean addDocumentList(List<ESModel> eSModelList, List<ESColumnModel> columns) {
		if(eSModelList == null || eSModelList.size() == 0){
			return false;
		}
		// 添加映射
		boolean initIndex = true;
		if(columns != null && columns.size() != 0) {
			ESModel esModel = eSModelList.get(0);
			try {
				initIndex = initIndex(client,esModel.getIndex(),esModel.getType(),columns);
			} catch (Exception e) {
				logger.error("添加映射失败！");
				e.printStackTrace();
			}
		}
		if(initIndex) {
			// 批量处理request
			BulkRequestBuilder bulkRequest = client.prepareBulk();
			for (ESModel model : eSModelList) {
				//System.out.println(model.getJsonString());
				bulkRequest.add(new IndexRequest(model.getIndex(), model.getType(), model.getId()).source(model.getJsonString()));
			}
			// 执行批量处理request
			BulkResponse bulkResponse = bulkRequest.get();
			// 处理错误信息
			if (bulkResponse.hasFailures()) {
				logger.error("====================批量创建索引过程中出现错误 下面是错误信息==========================");
				System.out.println("====================批量创建索引过程中出现错误 下面是错误信息==========================");
				long count = 0L;
				for (BulkItemResponse bulkItemResponse : bulkResponse) {
					System.out.println("发生错误的 索引id为 : " + bulkItemResponse.getId() + " ，错误信息为：" + bulkItemResponse.getFailureMessage());
					logger.error("发生错误的 索引id为 : " + bulkItemResponse.getId() + " ，错误信息为：" + bulkItemResponse.getFailureMessage());
					count++;
				}
				System.out.println( "====================批量创建索引过程中出现错误 上面是错误信息 共有: " + count + " 条记录==========================");
				logger.error("====================批量创建索引过程中出现错误 上面是错误信息 共有: " + count + " 条记录==========================");
				return false;
			}
			return true;
		}else {
			logger.error("====================初始化索引失败==========================");
		}
		return false;
	}
	/**
	 * 添加单条
	 */
	public boolean addDocument(ESModel model, List<ESColumnModel> columns) {
		boolean initIndex = true;
		if(columns != null && columns.size() != 0) {
			try {
				initIndex = initIndex(client,model.getIndex(),model.getType(),columns);
			} catch (Exception e) {
				logger.error("创建映射失败");
				e.printStackTrace();
			}
		}
		if(initIndex) {
			client.prepareIndex(model.getIndex(), model.getType(), model.getId()).setSource(model.getJsonString()).get();
			return true;
		}
		return false;
	}
	
	/**
	 * 修改
	 * @throws IOException 
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public boolean modifyDocument(ESModel model, List<ESColumnModel> columns) {
		 UpdateResponse updateResponse;
		try {
			updateResponse = client.update(new UpdateRequest(model.getIndex(), model.getType(), model.getId())
						.doc(model.getJsonString())).get();
		System.out.println("版本："+updateResponse.getVersion());
		System.out.println("是否创建成功："+updateResponse.isCreated());
		return true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		 return false;
	}

	/**
	 * 根据id删除
	 */
	public boolean deleteById(ESModel eSModelList) {
		BulkRequestBuilder deleteBulk = client.prepareBulk();
		deleteBulk.add(client.prepareDelete(eSModelList.getIndex(), eSModelList.getType(), eSModelList.getId()));
		deleteBulk.execute().actionGet();
		return true;
	}

	/**
	 * 批量删除
	 */
	public boolean deleteIndex(List<ESModel> eSModelList) {
		BulkRequestBuilder deleteBulk = client.prepareBulk();
		for (ESModel esModel : eSModelList) {
			deleteBulk.add(client.prepareDelete(esModel.getIndex(), esModel.getType(), esModel.getId()));
		}
		deleteBulk.execute().actionGet();
		return true;
	}

	/**
	 * 根据id查询
	 */
	public SearchHits searchByIds(ESModel model) {
		SearchResponse searchResponse = client.prepareSearch(model.getIndex()).setTypes(model.getType())
				.setQuery(QueryBuilders.idsQuery().ids(model.getId()))
				.get();
		SearchHits hits = searchResponse.getHits();//获取数据的结果集对象，获取命中次数
		return hits;
	}

	/**
	 * 查询所有
	 * QueryBuilders.matchAllQuery()
	 * */
	public SearchHits searchAll(ESModel model) {
		SearchResponse searchResponse = client.prepareSearch(model.getIndex()).setTypes(model.getType()).setSize(10000)
				.setQuery(QueryBuilders.matchAllQuery())
				.get();
		SearchHits hits = searchResponse.getHits();//获取数据的结果集对象，获取命中次数
		return hits;
	}

	public Long searchAllSize(ESModel model) {
		SearchResponse searchResponse = client.prepareSearch(model.getIndex()).setTypes(model.getType()).setSize(0)
				.setQuery(QueryBuilders.matchAllQuery())
				.get();
		SearchHits hits = searchResponse.getHits();//获取数据的结果集对象，获取命中次数
		return hits.getTotalHits();
	}

	public SearchHits queryCombinatorial(ESModel model, Page page) {
    	//long startTime_es = System.currentTimeMillis();//获取当前时间
    	BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
    	Map<String, String> andObject = model.getAndObject();
    	Map<String, String> notObject = model.getNotObject();
    	Map<String, String> orObject = model.getOrObject();
    	Map<String, String> likeObject = model.getLikeObject();
    	Map<String, String> likeFaultObject = model.getLikeFaultObject();
    	Map<String, String[]> rangeObject = model.getRangeObject();
    	Map<String, String[]> inObject = model.getInObject();
    	Map<String, String> sortObject = model.getSortObject();
    	Map<String, String> isNullObject = model.getIsNullObject();
    	if(andObject != null) {
    		for(String key : andObject.keySet()){ 
    			boolQuery.must(QueryBuilders.termQuery(key, andObject.get(key)));
        	}
    		
    	}
    	if(notObject != null) {
    		for(String key : notObject.keySet()){ 
    			boolQuery.mustNot(QueryBuilders.termQuery(key, notObject.get(key)));
    		}
    		
    	}
    	if(orObject != null) {
    		for(String key : orObject.keySet()){ 
    			boolQuery.should(QueryBuilders.termQuery(key, orObject.get(key)));
    		}
    		
    	}
    	
    	 //通配符模糊查询
        if(likeObject != null) {
    		for(String key : likeObject.keySet()){ 
    			boolQuery.must(QueryBuilders.wildcardQuery(key, "*"+likeObject.get(key)+"*"));
    		}
    		
    	}
        //根据位置模糊查询（可以容错）
        if(likeFaultObject != null) {
        	for(String key : likeFaultObject.keySet()){ 
        		boolQuery.must(QueryBuilders.fuzzyQuery(key, likeFaultObject.get(key)));
        	}
        	
        }
        //范围查询
        if(rangeObject != null) {
        	for(String key : rangeObject.keySet()){ 
        		boolQuery.must(QueryBuilders.rangeQuery(key).from(rangeObject.get(key)[0]).to(rangeObject.get(key)[1]));
        	}
        	
        }
        //in
        if(inObject != null) {
        	for(String key : inObject.keySet()){ 
        		boolQuery.must(QueryBuilders.termsQuery(key,inObject.get(key)));
        	}
        	
        }
        //is null or  not null
        if(isNullObject != null) {
        	for(String key : isNullObject.keySet()){ 
        		if("isNull".equals(key)) {
        			boolQuery.must(QueryBuilders.existsQuery(isNullObject.get(key)));
        		}
        		if("notNull".equals(key)) {
        			boolQuery.mustNot(QueryBuilders.existsQuery(isNullObject.get(key)));
        		}
        	}
        	
        }

        QueryBuilder queryBuilder = boolQuery;
        SearchRequestBuilder setQuery = client.prepareSearch(model.getIndex()).setTypes(model.getType()).setQuery(queryBuilder);
        //排序
        if(sortObject != null) {
        	for(String key : sortObject.keySet()){ 
        		if("desc".equals(sortObject.get(key))){
        			setQuery.addSort(key, SortOrder.DESC);
        		}else{
        			setQuery.addSort(key, SortOrder.ASC);
        		}
        	}
        	
        }
        //分页（深度分页）
        if(page != null) {
        	int currentPage = 0;
        	if(page.getCurrentPage() == 0) {
        		currentPage = page.getCurrentPage();
        	}else if(page.getCurrentPage() > 0) {
        		currentPage = page.getCurrentPage() - 1;
        	}
        	setQuery.setFrom(currentPage).setSize(page.getSize());
        }
        // 分页（scroll）
        
        SearchResponse searchResponse = setQuery.get();
		SearchHits hits = searchResponse.getHits();//获取数据的结果集对象，获取命中次数
		// 如果有分页显示条数
		if(page != null) {
			Long allRow = hits.getTotalHits();
			page.setAllRow(allRow.intValue());
		}
		//long endTime_es = System.currentTimeMillis();//结束时间
		//System.out.println("ES查询运行时间："+(endTime_es-startTime_es)+"ms");
		return hits;
	}
	/**
	 * 获取集群连接
	 * @param clusterName
	 * @param nodeIpInfo
	 * @return
	 */
	private Client clusterClient(String clusterName,String nodeIpInfo) {
		// 设置集群的名字
		Settings settings = Settings.settingsBuilder().put("client.transport.sniff", false).put("cluster.name", clusterName).build();
		// 创建集群client并添加集群节点地址
		client = TransportClient.builder().settings(settings).build();
		Map<String, Integer> nodeMap = parseNodeIpInfo(nodeIpInfo);
		for (Map.Entry<String, Integer> entry : nodeMap.entrySet()) {
			try {
				((TransportClient) client).addTransportAddress(
						new InetSocketTransportAddress(InetAddress.getByName(entry.getKey()), entry.getValue()));
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}

		return client;
	}

	/**
	 * 解析节点IP信息,多个节点用逗号隔开,IP和端口用冒号隔开
	 * 
	 * @return
	 */
	private Map<String, Integer> parseNodeIpInfo(String nodeIpInfo) {
		String[] nodeIpInfoArr = nodeIpInfo.split(",");
		Map<String, Integer> map = new HashMap<String, Integer>(nodeIpInfoArr.length);
		for (String ipInfo : nodeIpInfoArr) {
			String[] ipInfoArr = ipInfo.split(":");
			map.put(ipInfoArr[0], Integer.parseInt(ipInfoArr[1]));
		}
		return map;
	}
	
	/**
	  * 初始化索引
	  * @param client
	  * @param indexName 数据库名
	  * @param indexType 表名
	  * @param cols 字段列表
	  * @return 初始化成功,返回true；否则返回false
	 * @throws Exception
	  */
	 private boolean initIndex(Client client,String indexName,String indexType ,List<ESColumnModel> cols) throws Exception  {
	     if(StringUtil.isEmpty(indexName) || StringUtil.isEmpty(indexType) || CollectionUtils.isEmpty(cols)) {
	         return false;
	     }
	     indexName = indexName.toLowerCase();
	     indexType = indexType.toLowerCase();
	     //判断索引库是否存在  
	     if(isExistsIndex(indexName)) { 
	    	 if(isExistsType(indexName,indexType)) {
	    		 return true;
	    	 }
	          OpenIndexRequestBuilder openIndexBuilder = new OpenIndexRequestBuilder(client.admin().indices(), OpenIndexAction.INSTANCE);  
	             openIndexBuilder.setIndices(indexName).execute().actionGet();  
	     }else{  
	          //不存在则新建索引库  
	          client.admin().indices().prepareCreate(indexName).execute().actionGet();  
	     } 
	     TypesExistsRequest ter = new TypesExistsRequest(new String[]{indexName.toLowerCase()}, indexType);  
	     boolean typeExists = client.admin().indices().typesExists(ter).actionGet().isExists();  
	     //如果 存在 返回!不能覆盖mapping  
	     if(typeExists) {  
	         return true;  
	     }  
	     //定义索引字段属性  
	     XContentBuilder mapping = jsonBuilder().startObject().startObject(indexType).startObject("properties");  
	     for (ESColumnModel col : cols) {  
	         String colName = col.getName().toLowerCase().trim();  
	         String colType = col.getType() == null?null:col.getType().toLowerCase().trim();  
	                       
	         if("string".equals(colType)) {  
	             mapping.startObject(colName).field("type", colType).field("store", ""+col.isStore()).field("analyzer", col.getAnalyzer()).field("include_in_all", col.isStore()).field("boost", col.getBoost()).endObject();  
	         }else if("long".equals(colType)) {                
	             mapping.startObject(colName).field("type", colType).field("index", "not_analyzed").field("include_in_all", false).endObject();  
	         }else if("date".equals(colType)) {  
	             mapping.startObject(colName).field("type", colType).field("format", "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd").field("index", "not_analyzed").field("include_in_all", false).endObject();  
	         }else if("integer".equals(colType)) {                
	             mapping.startObject(colName).field("type", colType).field("index", "not_analyzed").field("include_in_all", false).endObject();  
	         }else if("keyword".equals(colType)) {
	        	 mapping.startObject(colName).field("type", "string").field("index", "not_analyzed").field("null_value", "NULL").endObject();
	         }else {  
	             mapping.startObject(colName).field("type", "string").field("index", "not_analyzed").endObject();  
	         }  
	              
	        }  
	        mapping.endObject().endObject().endObject();  
	        PutMappingRequest mappingRequest = Requests.putMappingRequest(indexName).type(indexType).source(mapping);  
	        PutMappingResponse response = client.admin().indices().putMapping(mappingRequest).actionGet();  //.actionGet().isExists();  get();
	     return response.isAcknowledged();
	 }

	 /**
	 * 判断指定的索引名是否存在
	 * 
	 * @param indexName 索引名
	 * @return 存在：true; 不存在：false;
	 */
	private boolean isExistsIndex(String indexName) throws Exception {
		IndicesExistsResponse  response = client.admin().indices().exists(new IndicesExistsRequest().indices(new String[]{indexName})).actionGet();
        return response.isExists();
	}
	
	/**
	 * 判断指定的索引的类型是否存在
	 * 
	 * @param indexName 索引名
	 * @param indexType 索引类型
	 * @return 存在：true; 不存在：false;
	 */
	private boolean isExistsType(String indexName, String indexType) throws Exception {
		if(!isExistsIndex(indexName)){
			return false;
		}
		TypesExistsResponse response = client.admin().indices().typesExists(new TypesExistsRequest(new String[] { indexName }, indexType)).actionGet();
		return response.isExists();
	}
}
