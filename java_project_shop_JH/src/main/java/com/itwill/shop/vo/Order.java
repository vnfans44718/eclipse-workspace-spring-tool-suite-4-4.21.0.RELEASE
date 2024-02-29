package com.itwill.shop.vo;
/**
VO(Value Object),DTO(Data Transfer Object)
	- orders 테이블 1개 row의 데이타의 값을 가지는객체
	- orders 테이블 1개 row의 데이타값을 이동(파라메타,리턴데이타)시키기위한객체 
	- orders 테이블의 컬럼과 동일한수의 멤버변수를가지는객체

	이름      널?       유형            
	------- -------- ------------- 
	O_NO    NOT NULL NUMBER(10)    //PK
	O_DESC           VARCHAR2(100) 
	O_DATE           DATE          
	O_PRICE          NUMBER(10)    
	USERID           VARCHAR2(100) //FK
*/

import java.util.Date;
import java.util.List;

public class Order {
	private int oNo;//PK
	private String oDesc;
	private Date oDate;
	private int oPrice;
	/**********FK*********/
	private User user;
	
	/*
	 *  Order 1 : OderItem N
	 * 
	*/  
	private List<OrderItem> orderItemList;
}













