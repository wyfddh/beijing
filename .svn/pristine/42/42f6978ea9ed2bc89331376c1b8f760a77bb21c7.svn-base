package com.tj720.admin.service;


import com.tj720.admin.base.service.BaseService;
import com.tj720.admin.dto.MipTourCollectionDto;
import com.tj720.admin.dto.MipTourDto;
import com.tj720.admin.model.MipTour;
import com.tj720.mip.utils.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MipTourService extends BaseService<MipTour> {

    /**
     * 添加导览
     * @param record
     * @return
     */
    int insert(MipTour record);


    /**
     * 查询导览列表
     * @param
     * @return
     */
    List<MipTour> selectMipTourList(String name, String status, Page page, String publishOrg,List<String> orgList, String currentOrgId);


    /**
     * 编辑导览
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MipTourDto record);


    /**
     * 删除导览
     * @param record
     * @return
     */
    int updateByPrimaryKey(MipTourDto record);

    @Override
    default int deleteByPrimaryKey(String id) {
        return 0;
    }

    /**
     * 根据id查询导览
     * @param id
     * @return
     */
    MipTour selectMipTourById(String id);

    List<MipTourCollectionDto> getCollectionList(String orgId,String tourId,MipTourCollectionDto search,Page page);

    int countCollectionList(String orgId,String tourId,MipTourCollectionDto search);

    /**
     * 获取导览图集
     * @param tourId
     * @return
     */
    List<MipTourCollectionDto> getListByTourId(String tourId);

}
