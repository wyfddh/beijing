package com.tj720.admin.model;

public class MipOpenFossilInfoWithBLOBs extends MipOpenFossilInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_open_fossil_info.description
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_open_fossil_info.remark
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_open_fossil_info.description
     *
     * @return the value of mip_open_fossil_info.description
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_open_fossil_info.description
     *
     * @param description the value for mip_open_fossil_info.description
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_open_fossil_info.remark
     *
     * @return the value of mip_open_fossil_info.remark
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_open_fossil_info.remark
     *
     * @param remark the value for mip_open_fossil_info.remark
     *
     * @mbggenerated Wed Aug 09 11:14:20 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}