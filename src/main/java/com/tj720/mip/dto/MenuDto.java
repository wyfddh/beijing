package com.tj720.mip.dto;

import java.io.Serializable;
import java.util.List;

import com.tj720.mip.model.Menu;

public class MenuDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Menu menu;
	private List<Menu> subMenu;
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public List<Menu> getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(List<Menu> subMenu) {
		this.subMenu = subMenu;
	}
	
}