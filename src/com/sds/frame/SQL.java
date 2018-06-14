package com.sds.frame;

public class SQL {//sql문도 따로 관리해주기 위함.
	//JAVA와 구분하기 위해서 대문자로 쓰는것이 통상적임.
	public static String insertCustomer="INSERT INTO TB_USER VALUES(?,?,?)";
	public static String insertItem="INSERT INTO TB_ITEM VALUES((select nvl(max(ITEM_ID),0)+1 from TB_ITEM),?,?,?)";
	public static String getCustomer="SELECT * FROM TB_USER WHERE ID = ?";
	public static String getCustomerItem="SELECT * FROM TB_ITEM WHERE ID = ?";
	public static String listCustomer="SELECT * FROM TB_USER";
	public static String listItem="SELECT * FROM TB_ITEM WHERE ID = ?";
}
