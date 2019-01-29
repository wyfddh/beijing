package com.design.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 树形结构
 * @author zhangceven
 *
 */
public class Tree {
	
	private String id; // 树形菜单节点编号
	
	private String text; // 树形菜单名称
	
	private String parent; // 树形菜单父节点编号
	
	private List<Tree> children = new ArrayList<>();

	public Tree() {
		
	}

	public Tree(String id, String text, String parent, List<Tree> children) {
		this.id = id;
		this.text = text;
		this.parent = parent;
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public List<Tree> getChildren() {
		return children;
	}

	public void setChildren(List<Tree> children) {
		this.children = children;
	}

}
