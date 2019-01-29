package com.tj720.admin.dao.map;

import com.tj720.admin.model.DcBorrow;
import com.tj720.admin.model.DcBorrowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcBorrowMapper {
	int countByExample(DcBorrowExample example);

    int deleteByExample(DcBorrowExample example);

    int deleteByPrimaryKey(String id);

    int insert(DcBorrow record);

    int insertSelective(DcBorrow record);

    List<DcBorrow> selectByExample(DcBorrowExample example);

    DcBorrow selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DcBorrow record, @Param("example") DcBorrowExample example);

    int updateByExample(@Param("record") DcBorrow record, @Param("example") DcBorrowExample example);

    int updateByPrimaryKeySelective(DcBorrow record);

    int updateByPrimaryKey(DcBorrow record);
}