package com.design.core.config.util;

import java.util.Comparator;

import com.design.entity.CgFormLgFieldEntity;
/**
 * 字段 顺序  排序
 * @author jueyue
 *  2013年7月6日
 */
public class FieldNumComparator implements Comparator<CgFormLgFieldEntity> {

	
	public int compare(CgFormLgFieldEntity o1, CgFormLgFieldEntity o2) {
		if (o1 == null || o1.getOrderNum() == null || o2 == null || o2.getOrderNum() == null)
			return -1;
		Integer thisVal = o1.getOrderNum();
		Integer anotherVal = o2.getOrderNum();
		return (thisVal < anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1));
	}

}
