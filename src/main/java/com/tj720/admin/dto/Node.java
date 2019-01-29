package com.tj720.admin.dto;

import java.io.Serializable;

/**
 * 栏目树结构
 * @author zwp
 *
 * 2017年11月16日 上午11:16:51
 * 
 * { id:1, pId:0, name:"一级分类", open:true},
 */
public class Node implements Serializable{
	private static final long serialVersionUID = 3204869199379326135L;
	
	private String id; //栏目id
	private String pId;//栏目父id
	private String name; //栏目名称
	private Boolean open;//栏目是否打开
	private String description;//栏目描述
	private String type;//类型
	private String status;	//状态
	private String uniqueName;	//唯一名称
	
	
	public Node() {
		super();
	}
	public Node(String id, String pId, String name, Boolean open) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.open = open;
	}
	public Node(String id, String pId, String name, Boolean open,String description,String type, String status, String uniqueName) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.open = open;
		this.description = description;
		this.type = type;
		this.status = status;
		this.uniqueName = uniqueName;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getOpen() {
		return open;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getUniqueName() {
		return uniqueName;
	}
	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Node [id=" + id + ", pId=" + pId + ", name=" + name + ", open=" + open + "]";
	}
}
