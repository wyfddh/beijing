package com.tj720.mip.model;

import java.util.List;

public class SubjectNode {
    private String id;

    private String name;

    private String description;		//描述

    private String parentid;

    private String create_time;

    private String uniqueName;
    
    private Integer pos;

    private List<SubjectNode> children;


	public Integer getPos() {
		return pos;
	}

	public void setPos(Integer pos) {
		this.pos = pos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUniqueName() {
		return uniqueName;
	}

	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}

	public List<SubjectNode> getChildren() {
		return children;
	}

	public void setChildren(List<SubjectNode> children) {
		this.children = children;
	}

    
}
