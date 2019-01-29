package com.tj720.mip.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="mip_desk")
public class ThreeDimDesk implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "deskType")
	private String deskType;
	@Column(name = "posX")
	private float posX;
	@Column(name = "posY")
	private float posY;
	@Column(name = "posZ")
	private float posZ;
	@Column(name = "itemId")
	private int itemId;
	@Column(name = "romeId")
	private int romeId;
	
	
	public int getRomeId() {
		return romeId;
	}
	public void setRomeId(int romeId) {
		this.romeId = romeId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeskType() {
		return deskType;
	}
	public void setDeskType(String deskType) {
		this.deskType = deskType;
	}
	public float getPosX() {
		return posX;
	}
	public void setPosX(float posX) {
		this.posX = posX;
	}
	public float getPosY() {
		return posY;
	}
	public void setPosY(float posY) {
		this.posY = posY;
	}
	public float getPosZ() {
		return posZ;
	}
	public void setPosZ(float posZ) {
		this.posZ = posZ;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	

	
}
