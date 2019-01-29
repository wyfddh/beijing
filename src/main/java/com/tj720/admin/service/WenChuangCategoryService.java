package com.tj720.admin.service;

import java.util.List;

import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.model.MipWenchuangCategory;

public interface WenChuangCategoryService extends BaseService<MipWenchuangCategory> {

	List<MipWenchuangCategory> getAll();

}
