package com.tj720.mip.controller.threeDim;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tj720.mip.framework.MyException;
import com.tj720.mip.model.ThreeDimDesk;
import com.tj720.mip.model.ThreeDimItem;
import com.tj720.mip.service.table.ThreeDimDeskService;
import com.tj720.mip.service.table.ThreeDimItemService;

@Controller
@RequestMapping("/3d/source")
public class ThreeDimController {

	@Autowired
	private ThreeDimDeskService threeDimDeskService;

	@Autowired
	private ThreeDimItemService threeDimItemService;

	/**
	 * 通过展台id查询符合条件的展品列表
	 * 
	 * @param deskType
	 * @return List<ThreeDimItem>
	 * @throws MyException
	 */
	@RequestMapping("/list.do")
	@ResponseBody
	public List<ThreeDimItem> list(@RequestParam(value = "deskId", required = false) int id) throws MyException {

		// 通过deskId查询3D展柜信息
		ThreeDimDesk threeDimDesk = threeDimDeskService.getById(id);
		// 获取展柜类型
		String deskType = threeDimDesk.getDeskType();
		// 获取展柜展示展品id
		int itemId = threeDimDesk.getItemId();

		// 通过展柜类型查询展品信息列表
		List<ThreeDimItem> itemList = threeDimItemService
				.getByHQL("from ThreeDimItem tdi where tdi.deskType='" + deskType + "'", null);
		// 去除当前展品
		Iterator<ThreeDimItem> iterator = itemList.iterator();
		while (iterator.hasNext()) {
			ThreeDimItem item = iterator.next();
			if (item.getId() == itemId) {
				iterator.remove();
			}
		}
		/*
		 * for (ThreeDimItem item : itemList) { if (item.getId()== itemId) {
		 * itemList.remove(item); } }
		 */
		// 返回符合条件展品list集合
		return itemList;
	}

	/**
	 * 
	 * @param currItemId
	 *            当前展品id
	 * @param newItemId
	 *            选中展品id
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/updateDeskItem.do")
	@ResponseBody
	public Map<String, Object> updateDeskItem(@RequestParam(value = "oldItemId", required = false) int currItemId,
			@RequestParam(defaultValue = "0") int newItemId) throws MyException {

		Map<String, Object> map = new HashMap<>();
		try {
			// 获取到要修改的展品对象
			ThreeDimItem currItem = threeDimItemService.getById((Serializable) currItemId);
			int deskId = currItem.getDeskId();// 当前展台id
			String deskType = currItem.getDeskType();
			int romeId = currItem.getRomeId();// 当前展厅id

			// 获取当前展品展柜信息，并修改其保存的展品id
			ThreeDimDesk desk = threeDimDeskService.getById((Serializable) deskId);
			
			
			ThreeDimItem newItem = null;
			
			if (newItemId != 0) {
				// 更换当前藏品
				// 通过藏品newItemId获取展品信息
				newItem = threeDimItemService.getById((Serializable) newItemId);

				// 判断当前展品是否展出
				if (newItem.getStatus() == 0) {
					// 未展出
					// 修改当前展品信息
					newItem.setDeskId(deskId);
//					newItem.setDeskType(deskType);
//					newItem.setRomeId(romeId);
					newItem.setStatus(1);
					desk.setItemId(newItemId);
					
					
					
					threeDimDeskService.update(desk);
					threeDimItemService.update(newItem);
					
					map.put("success", "修改成功");
				} else {
					map.put("fail", "当前展品已展出，请选择其他藏品");
				}
			}
			
				// 修改展柜中原展品的信息
				// 修改展品中的信息
				currItem.setStatus(0);
				currItem.setDeskId(0);
//				currItem.setDeskType("");
//				currItem.setRomeId(0);
				
				threeDimDeskService.update(desk);
				
				threeDimItemService.update(currItem);
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return map;
	}

	/**
	 * 通过展品id查询展品信息
	 * 
	 * @param id
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/item.do")
	@ResponseBody
	public ThreeDimItem getItemById(Integer id) throws MyException {

		ThreeDimItem item = threeDimItemService.getById(id);

		return item;
	}

	/**
	 * 修改展台展品信息
	 */

	/**
	 * 查询所有展品信息
	 * 
	 * @param id
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/allItems.do")
	@ResponseBody
	public List<ThreeDimItem> getItemByRomeNo(int romeId) throws MyException {

		// 通过展厅编号获取展品信息及相关展台id
		List<ThreeDimItem> itemList = threeDimItemService
				.getByHQL("from ThreeDimItem tdi where tdi.romeId=" + romeId + " and status=1", null);

		// 返回list集合
		return itemList;

	}

}
