package com.example.boot1.RestrauntEntity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "RestrauntTbl")
public class RestrauntEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serialNo;
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	@Column
	private String name;
	@Column
	private int avgPrice ;
	@Column
	private short ratings;
	@Column
	private String typeOfFood;
	@Column
	private String ownerName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(int avgPrice) {
		this.avgPrice = avgPrice;
	}
	public short getRatings() {
		return ratings;
	}
	public void setRatings(short ratings) {
		this.ratings = ratings;
	}
	public String getTypeOfFood() {
		return typeOfFood;
	}
	public void setTypeOfFood(String typeOfFood) {
		this.typeOfFood = typeOfFood;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
}
