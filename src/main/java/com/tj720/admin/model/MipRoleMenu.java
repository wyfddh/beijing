package com.tj720.admin.model;

public class MipRoleMenu {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_role_menu.id
     *
     * @mbggenerated Thu Jun 28 15:17:25 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_role_menu.roleId
     *
     * @mbggenerated Thu Jun 28 15:17:25 CST 2018
     */
    private String roleid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mip_role_menu.menuId
     *
     * @mbggenerated Thu Jun 28 15:17:25 CST 2018
     */
    private String menuid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_role_menu.id
     *
     * @return the value of mip_role_menu.id
     *
     * @mbggenerated Thu Jun 28 15:17:25 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_role_menu.id
     *
     * @param id the value for mip_role_menu.id
     *
     * @mbggenerated Thu Jun 28 15:17:25 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_role_menu.roleId
     *
     * @return the value of mip_role_menu.roleId
     *
     * @mbggenerated Thu Jun 28 15:17:25 CST 2018
     */
    public String getRoleid() {
        return roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_role_menu.roleId
     *
     * @param roleid the value for mip_role_menu.roleId
     *
     * @mbggenerated Thu Jun 28 15:17:25 CST 2018
     */
    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mip_role_menu.menuId
     *
     * @return the value of mip_role_menu.menuId
     *
     * @mbggenerated Thu Jun 28 15:17:25 CST 2018
     */
    public String getMenuid() {
        return menuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mip_role_menu.menuId
     *
     * @param menuid the value for mip_role_menu.menuId
     *
     * @mbggenerated Thu Jun 28 15:17:25 CST 2018
     */
    public void setMenuid(String menuid) {
        this.menuid = menuid == null ? null : menuid.trim();
    }
}