package com.tj720.mip.framework.base;

import java.util.List;
import java.util.Map;

import com.tj720.mip.model.MipOpenFossilInfo;
import com.tj720.mip.model.VirtualShowroom;
import com.tj720.mip.utils.Page;

public interface IBaseService<T extends BaseModel> {

	/**
	 * 保存对象
	 * */
	public T save(T model);

	public void update(T model);
	
	void insert(Object obj);

	/**
	 * 根据示例对象删除
	 * */
	public void delete(T model);

	/**
	 * 根据主键获取对象
	 * */
	public T get(String id);

	/**
	 * 根据示例对象获取对象列表
	 * */
	public List<T> findByExample(T model);

	/**
	 * 根据示例对象获取对象列表
	 * */
	public List<T> loadAll(T model);

	/**
	 * 根据查询条件Map集合查询数据集合
	 * @param map 查询条件Map集合
	 * @param page 分页参数
	 * @param order 排序规则（为空则按创建时间降序排列）
	 */
	public List<T> findByMap(Map<String, Object> map,
			Page pageBean, String order);
	
	/**
	 * 根据查询条件Map集合查询总数量
	 * @param map
	 * @return
	 */
	public int getCount(Map<String, Object> map);

	List<?> queryByHql(String hql, Map<String, Object> map);

	void update(String hql, Map<String, Object> map);
	/**
	 * 删除前，先将对象数据存入log对象
	 * */
	void delete(T model, String modelName, String remark);
	/**
	 * 修改前，先将对象数据存入log对象
	 * */
	void update(T model, String modelName, String remark);

	List<T> findByMap(Map<String, Object> map, String construct, Page page, String order);

	List<?> queryByHql(String hql, Map<String, Object> map, Page page);
	
	void updateForIssue(VirtualShowroom virtualShowroom);
	
	List<?> findByObj(Map<String, Object> map, Object obj, Page pageBean, String order, String hqlCondition);

	List<?> findByHql(String hql, String modelName, Map<String, Object> map, Page page);
	
	/**
	 * 查询限定条数
	 */
	List<?> queryLimitByHql(String hql, int limit);
	List<?> queryLimitByHql(String hql);//limit=50

	public void deleteBySql(String sql);

	int deleteByHql(String hql);

	T getByHql(String hql);

	Object getDtoByHql(String hql);

	List<?> queryDtoByHql(String hql, Map<String, Object> map, Page pageBean);
}
