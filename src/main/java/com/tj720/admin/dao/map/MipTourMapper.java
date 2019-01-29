package com.tj720.admin.dao.map;


import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.dto.MipTourCollectionDto;
import com.tj720.admin.model.MipTour;
import com.tj720.mip.utils.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MipTourMapper extends BaseDao<MipTour>{


    int deleteByPrimaryKey(String id);

    /**
     * 添加导览
     * @param record
     * @return
     */
    int insert(MipTour record);

    /**
     * 添加导览
     * @param record
     * @return
     */
    int insertSelective(MipTour record);

    MipTour selectByPrimaryKey(String id);

    /**
     * 编辑导览
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MipTour record);

    int updateByPrimaryKeyWithBLOBs(MipTour record);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(MipTour record);

    /**
     * 查询导览列表
     * @param
     * @return
     */
    List<MipTour> selectMipTourList(@Param("name") String name,@Param("status") String status,@Param("startRow") Integer startRow, @Param("pageSize") Integer pageSize,@Param("publishOrg") String publishOrg ,@Param("orgList") List<String> orgList, @Param("currentOrgId") String currentOrgId);

    /**
     * 统计导览数量
     * @param name
     * @param status
     * @param publishOrg
     * @return
     */
    int countMipTourList(@Param("name") String name,@Param("status") String status,@Param("publishOrg") String publishOrg, @Param("orgList") List<String> orgList, @Param("currentOrgId") String currentOrgId);

    List<MipTourCollectionDto> getCollectionList(@Param("orgId") String orgId, @Param("tourId") String tourId, @Param("search") MipTourCollectionDto search,  @Param("startRow") Integer startRow, @Param("pageSize") Integer pageSize);

    int countCollectionList(@Param("orgId") String orgId, @Param("tourId") String tourId, @Param("search") MipTourCollectionDto search);
}