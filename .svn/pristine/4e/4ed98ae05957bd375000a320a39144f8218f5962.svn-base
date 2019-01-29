package com.tj720.admin.dao.map;

import com.tj720.admin.model.MipFrontLog;
import com.tj720.admin.model.MipFrontLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MipFrontLogMapper {
    int countByExample(MipFrontLogExample example);

    int deleteByExample(MipFrontLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(MipFrontLog record);

    int insertSelective(MipFrontLog record);

    List<MipFrontLog> selectByExample(MipFrontLogExample example);

    MipFrontLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MipFrontLog record, @Param("example") MipFrontLogExample example);

    int updateByExample(@Param("record") MipFrontLog record, @Param("example") MipFrontLogExample example);

    int updateByPrimaryKeySelective(MipFrontLog record);

    int updateByPrimaryKey(MipFrontLog record);
}