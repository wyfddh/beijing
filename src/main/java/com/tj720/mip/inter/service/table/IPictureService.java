package com.tj720.mip.inter.service.table;

import com.tj720.mip.framework.base.IBaseService;
import com.tj720.mip.model.Picture;

import java.util.List;

public interface IPictureService extends IBaseService<Picture>{

    List<String> getUrlsByIds(String[] split);
}
