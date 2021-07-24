package com.example.demo.model;

public class Coupen {
	private int id;
	private String offer_name; 
	private String offer_details; 
	private int available_count;
	
	public Coupen(int id,String offer_name,String offer_details,int available_count){
		this.id=id;
		this.offer_name=offer_name;
		this.offer_details=offer_details;
		this.available_count=available_count;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOffer_name() {
		return offer_name;
	}
	public void setOffer_name(String offer_name) {
		this.offer_name = offer_name;
	}
	public String getOffer_details() {
		return offer_details;
	}
	public void setOffer_details(String offer_details) {
		this.offer_details = offer_details;
	}
	public int getAvailable_count() {
		return available_count;
	}
	public void setAvailable_count(int available_count) {
		this.available_count = available_count;
	}
}
