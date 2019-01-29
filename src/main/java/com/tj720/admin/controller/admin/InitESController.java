package com.tj720.admin.controller.admin;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tj720.admin.dao.es.EsSearchDao;
import com.tj720.admin.dao.map.MipOpenCulturalrelicInfoMapper;
import com.tj720.admin.model.ESColumnModel;
import com.tj720.admin.model.ESModel;
import com.tj720.admin.model.MipOpenCulturalrelicInfoExample;
import com.tj720.admin.model.MipOpenCulturalrelicInfoWithBLOBs;
import com.tj720.admin.model.MuseumTagInfo;
import com.tj720.mip.framework.JsonResult;
import com.tj720.mip.utils.Page;


@RequestMapping("/ES")
@Controller
public class InitESController {

	@Autowired
	private EsSearchDao esSearchDao;
	@Autowired
	private MipOpenCulturalrelicInfoMapper mipOpenCulturalrelicInfoMapper;
	
	/**
	 * 博物馆标签查询测试
	 * http://192.168.5.9:8088/admin/ES/tagSearch.do?key=陶瓷
	 * @return
	 */
	@RequestMapping("tagSearch")
	@ResponseBody
	public JsonResult tagSearch(String key) {
		ESModel em = new ESModel();
		Map<String,String> likeMap = new HashMap<>();
		likeMap.put("tag",key);
		em.setLikeObject(likeMap);
		em.setType("tag");
		long startTime = System.currentTimeMillis();
		Page page = new Page();
		page.setCurrentPage(1);
		page.setSize(1000);
		SearchHits queryCombinatorial = esSearchDao.queryCombinatorial(em, page);
		long endTime = System.currentTimeMillis();
		System.out.println("查询花费：" + (endTime - startTime) + "毫秒" );
		List<MuseumTagInfo> list = new ArrayList<>();
		for(SearchHit searchHit : queryCombinatorial) {
			String sourceAsString = searchHit.getSourceAsString();
			MuseumTagInfo parseObject = JSON.parseObject(sourceAsString, MuseumTagInfo.class);
			list.add(parseObject);
		}
		return new JsonResult(1, JSON.toJSONString(list));
	}
	
	String[] tags = {"|革命博物馆|历史博物馆|牛逼|陶瓷|", "|革命|最美|","|好看|书法|","|绘画|书法|","|石器|陶器|","|好看|文具|","|钱币|票据|","|铜器|金银器|","|皮革|音响制品|","|雕塑|照相|"};
	/**
	 * 初始化博物馆标签
	 * http://192.168.5.9:8088/admin/ES/tagEs.do
	 * @return
	 */
	@RequestMapping("tagEs")
	@ResponseBody
	public String initTagEs() {
		List<ESModel> eSModelList = new ArrayList<ESModel>();  
		for(int i=100001; i<=1000000; i++) {
			
			String id = i + "";
			String name = "博物馆" + i;
			int index = (int)Math.round(Math.random()*(10));
			index = index >= 10 ? 9 : index;
			String tag = tags[index];
			MuseumTagInfo museumTagInfo = new MuseumTagInfo(id, name, tag);
			ESModel eSModel =new ESModel();
			eSModel.setType("tag");
			eSModel.setId(i + "");
			eSModel.setJsonString(JSON.toJSONString(museumTagInfo));
			eSModelList.add(eSModel);
			
		}
		List<ESColumnModel> columns = new LinkedList<>();
	    columns.add(new ESColumnModel("id"));
	    columns.add(new ESColumnModel("name"));
	    columns.add(new ESColumnModel("tag"));
	    esSearchDao.addDocumentList(eSModelList,columns);
		return "ok!";
	}
	/**
	 * http://localhost:8080/admin/ES/culturalInitES.do
	 * @return
	 */
	@RequestMapping("culturalInitES")
	@ResponseBody
	public String culturalInitES(){
		int startRow = 0;
		int pageSize = 10000;
		int size = 0;
		int allNumber = mipOpenCulturalrelicInfoMapper.countByExample(new MipOpenCulturalrelicInfoExample())/pageSize+1;
		System.out.println("共需要："+allNumber+"次");
		for(int i = 0;i<allNumber;i++) {
			startRow = i*10000;
			System.out.println(startRow);
			System.out.println(pageSize);
			System.out.println("==================完成第"+i+"==================");
			MipOpenCulturalrelicInfoExample example= new MipOpenCulturalrelicInfoExample();
			example.setStartPage(startRow);
			example.setSize(pageSize);
			List<MipOpenCulturalrelicInfoWithBLOBs> selectByExample = mipOpenCulturalrelicInfoMapper.selectByExampleWithBLOBs(example);
			System.out.println("查询出对象的大小："+selectByExample.size());
			size+=selectByExample.size();
			List<ESModel> eSModelList = new ArrayList<ESModel>();
			((ArrayList<ESModel>) eSModelList).ensureCapacity(10000);
			for(MipOpenCulturalrelicInfoWithBLOBs sd : selectByExample) {
				sd.setDescription("".equals(sd.getDescription())? null:sd.getDescription());
				ESModel eSModel =new ESModel();
				eSModel.setType("mipopenculturalrelicinfo");
				eSModel.setId(sd.getId());
				eSModel.setJsonString(JSON.toJSONString(sd));
				eSModelList.add(eSModel);
			}
			List<ESColumnModel> columns = new LinkedList<>();
			   columns.add(new ESColumnModel("id"));
			   columns.add(new ESColumnModel("collectionunit"));
			   columns.add(new ESColumnModel("dwid"));
			   columns.add(new ESColumnModel("gsno"));
			   columns.add(new ESColumnModel("fpic" ));
			   columns.add(new ESColumnModel("fpicwidth"));
			   columns.add(new ESColumnModel("fpicheight"));
			   columns.add(new ESColumnModel("gscollectionsnotype"));
			   columns.add(new ESColumnModel("gscollectionsno"));
			   columns.add(new ESColumnModel("collectiontype"));
			   columns.add(new ESColumnModel("name"));
			   columns.add(new ESColumnModel("indexname"));
			   columns.add(new ESColumnModel("formerly"));
			   columns.add(new ESColumnModel("foreignname"));
			   columns.add(new ESColumnModel("yeartype"));
			   columns.add(new ESColumnModel("gsspecificyear"));
			   columns.add(new ESColumnModel("collectionscategory"));
			   columns.add(new ESColumnModel("gstexturecategory"));
			   columns.add(new ESColumnModel("gstexturesubcategories"));
			   columns.add(new ESColumnModel("gstexture"));
			   columns.add(new ESColumnModel("actualquantityunit"));
			   columns.add(new ESColumnModel("actualquantity"));
			   columns.add(new ESColumnModel("gslength"));
			   columns.add(new ESColumnModel("gswidth"));
			   columns.add(new ESColumnModel("gsheight"));
			   columns.add(new ESColumnModel("size" ));
			   columns.add(new ESColumnModel("massrange"));
			   columns.add(new ESColumnModel("mass"));
			   columns.add(new ESColumnModel("massunit"));
			   columns.add(new ESColumnModel("collectionlevel"));
			   columns.add(new ESColumnModel("gssource"));
			   columns.add(new ESColumnModel("collectionplace" ));
			   columns.add(new ESColumnModel("endresiduelevel" ));
			   columns.add(new ESColumnModel("endresidualcondition"));
			   columns.add(new ESColumnModel("gsstoragetype"));
			   columns.add(new ESColumnModel("gsstoragestate"));
			   columns.add(new ESColumnModel("gsentrywarehousetimeframe"));
			   columns.add(new ESColumnModel("gsentrywarehouseyear"));
			   columns.add(new ESColumnModel("gsentrywarehousetime"));
			   columns.add(new ESColumnModel("gsauthor"));
			   columns.add(new ESColumnModel("gsversion" ));
			   columns.add(new ESColumnModel("gskeeponfile" ));
			   columns.add(new ESColumnModel("pictureids" ));
			   columns.add(new ESColumnModel("creator" ));
			   columns.add(new ESColumnModel("ishighquality" ));
			   columns.add(new ESColumnModel("isopen" ));
			   columns.add(new ESColumnModel("assessor" ));
			   columns.add(new ESColumnModel("fcreatedept" ));
			   columns.add(new ESColumnModel("fkey"));
			   columns.add(new ESColumnModel("threedimensionalcollection"));
			   columns.add(new ESColumnModel("ringbeatdata" ));
			   columns.add(new ESColumnModel("fvideo"));
			   columns.add(new ESColumnModel("faudio" ));
			   columns.add(new ESColumnModel("fmuseumid" ));
			   columns.add(new ESColumnModel("checkstate" ));
			   columns.add(new ESColumnModel("clickcounts"));
			   columns.add(new ESColumnModel("selectcounts"));
			   columns.add(new ESColumnModel("collectedcounts"));
			   columns.add(new ESColumnModel("submittime"));
			   columns.add(new ESColumnModel("updatedtime","long"));
			   columns.add(new ESColumnModel("createtime"));
			   columns.add(new ESColumnModel("status"));
			   columns.add(new ESColumnModel("sequence","integer"));
			   columns.add(new ESColumnModel("description","keyword"));
			   esSearchDao.addDocumentList(eSModelList,columns);
		}
		return "ok:"+size+"strip";
	}
}
