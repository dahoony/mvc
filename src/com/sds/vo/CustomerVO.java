package com.sds.vo;

import java.util.ArrayList;

public class CustomerVO {
	private String id;
	private String pwd;
	private String name;
	ArrayList<ItemVO> items;//분석 설계 때 한 Composition이나 Aggregation을 표현한 클래스
	
	public CustomerVO() {
	}

	public CustomerVO(String id, String pwd, String name) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}

	public CustomerVO(String id, String pwd, String name, ArrayList<ItemVO> items) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.items = items;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<ItemVO> getItem() {
		return items;
	}

	public void setItem(ArrayList<ItemVO> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "CustomerVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", items=" + items + "]";
	}
	
}
