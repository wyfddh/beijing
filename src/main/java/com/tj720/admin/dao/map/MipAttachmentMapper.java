package com.tj720.admin.dao.map;

import com.tj720.admin.base.dao.BaseDao;
import com.tj720.admin.model.MipAttachment;
import com.tj720.admin.model.MipAttachmentExample;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MipAttachmentMapper extends BaseDao<MipAttachment>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_attachment
     *
     * @mbggenerated Mon Jul 02 10:27:45 CST 2018
     */
    int countByExample(MipAttachmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_attachment
     *
     * @mbggenerated Mon Jul 02 10:27:45 CST 2018
     */
    int deleteByExample(MipAttachmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_attachment
     *
     * @mbggenerated Mon Jul 02 10:27:45 CST 2018
     */
    int deleteByPrimaryKey(String attId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_attachment
     *
     * @mbggenerated Mon Jul 02 10:27:45 CST 2018
     */
    int insert(MipAttachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_attachment
     *
     * @mbggenerated Mon Jul 02 10:27:45 CST 2018
     */
    int insertSelective(MipAttachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_attachment
     *
     * @mbggenerated Mon Jul 02 10:27:45 CST 2018
     */
    List<MipAttachment> selectByExample(MipAttachmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_attachment
     *
     * @mbggenerated Mon Jul 02 10:27:45 CST 2018
     */
    MipAttachment selectByPrimaryKey(String attId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_attachment
     *
     * @mbggenerated Mon Jul 02 10:27:45 CST 2018
     */
    int updateByExampleSelective(@Param("record") MipAttachment record, @Param("example") MipAttachmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_attachment
     *
     * @mbggenerated Mon Jul 02 10:27:45 CST 2018
     */
    int updateByExample(@Param("record") MipAttachment record, @Param("example") MipAttachmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_attachment
     *
     * @mbggenerated Mon Jul 02 10:27:45 CST 2018
     */
    int updateByPrimaryKeySelective(MipAttachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mip_attachment
     *
     * @mbggenerated Mon Jul 02 10:27:45 CST 2018
     */
    int updateByPrimaryKey(MipAttachment record);
    
    List<HashMap> getAttachmentById(@Param("attFkId") String attFkId,@Param("attId") String attId,@Param("startRow") int startRow,@Param("pageSize") Integer pageSize);
    
    Integer countAttachmentById(@Param("attFkId") String attFkId,@Param("attId") String attId);
    
    List<MipAttachment> getAttachmentsByFkId(@Param("fkId") String fkId);

}