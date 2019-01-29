package com.tj720.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj720.admin.common.util.IdUtils;
import com.tj720.admin.common.util.Utils;
import com.tj720.admin.dao.map.GmCulturalProductsMapper;
import com.tj720.admin.model.GmCulturalProducts;
import com.tj720.admin.service.GmCulturalProductsService;
@Service
public class GmCulturalProductsServiceImpl implements GmCulturalProductsService {

	@Autowired
	private GmCulturalProductsMapper gmCulturalProductsMapper;
	@Override
	public void extractData(List<String[]> readExcel, String id) {
		List<List<String[]>> splitList = Utils.split(readExcel,1000);
		for (int i = 0;i < splitList.size();i++) {
			List<GmCulturalProducts> li = new ArrayList<GmCulturalProducts>();
			for (int j = 0;j < splitList.get(i).size();j++) {
				String[] strings = splitList.get(i).get(j);
				int len = strings.length;
				if ((!StringUtils.isBlank(strings[0])) && Utils.isDigitalNumber(strings[0])) {
					
					GmCulturalProducts gmCulturalProducts = new GmCulturalProducts();
					String nextId = IdUtils.nextId(gmCulturalProducts);
					gmCulturalProducts.setReportUploadId(id);
					gmCulturalProducts.setId(nextId);
					gmCulturalProducts.setNum(strings[0]);
					if (len >= 2) {
						gmCulturalProducts.setNewProdectName(strings[1]);
					}
					if (len >= 3) {
						gmCulturalProducts.setProductCharacteristic(strings[2]);
					}
					if (len >= 4) {
						gmCulturalProducts.setDevelopmentCost(strings[3]);
					}
					if (len >= 5) {
						gmCulturalProducts.setSalesVolume(strings[4]);
					}
					
					li.add(gmCulturalProducts);
				}
			}
			if (li.size() > 0) {
				
				this.insertBatch(li);
			}
		}
		
		
	}
	public void insertBatch(List<GmCulturalProducts> list ) {
		gmCulturalProductsMapper.insertBatch(list);
	}
	@Override
	public void deleteByReportUploadId(String id) {
		gmCulturalProductsMapper.deleteByReportUploadId(id);
		
	}

}
