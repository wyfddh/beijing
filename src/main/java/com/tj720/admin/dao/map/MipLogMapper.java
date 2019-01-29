package com.tj720.admin.dao.map;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tj720.admin.dto.MipLogSearchDto;
import com.tj720.admin.model.MipLog;
import com.tj720.admin.model.MipLogExample;

public interface MipLogMapper {
    int countByExample(MipLogExample example);

    int deleteByExample(MipLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(MipLog record);

    int insertSelective(MipLog record);

    List<MipLog> selectByExampleWithBLOBs(MipLogExample example);

    List<MipLog> selectByExample(MipLogExample example);

    MipLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MipLog record, @Param("example") MipLogExample example);

    int updateByExampleWithBLOBs(@Param("record") MipLog record, @Param("example") MipLogExample example);

    int updateByExample(@Param("record") MipLog record, @Param("example") MipLogExample example);

    int updateByPrimaryKeySelective(MipLog record);

    int updateByPrimaryKeyWithBLOBs(MipLog record);

    int updateByPrimaryKey(MipLog record);
    
    List<MipLog> getMipLogList(@Param("log") MipLogSearchDto mipLog, @Param("startRow") Integer startRow, @Param("pageSize") Integer pageSize);
    int countMipLogList(@Param("log") MipLogSearchDto mipLog);
}