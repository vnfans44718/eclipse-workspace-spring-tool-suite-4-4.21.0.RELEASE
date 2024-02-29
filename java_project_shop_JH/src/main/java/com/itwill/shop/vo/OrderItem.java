package com.itwill.shop.vo;
/**
VO(Value Object),DTO(Data Transfer Object)
	- order_item 테이블 1개 row의 데이타의 값을 가지는객체
	- order_item 테이블 1개 row의 데이타값을 이동(파라메타,리턴데이타)시키기위한객체 
	- order_item 테이블의 컬럼과 동일한수의 멤버변수를가지는객체
	
	이름     널?       유형         
	------ -------- ---------- 
	OI_NO  NOT NULL NUMBER(10) //PK
	OI_QTY          NUMBER(10) 
	O_NO            NUMBER(10) //FK
	P_NO            NUMBER(10) //FK
*/

public class OrderItem {
	private int oiNo;//PK
	private int oiQty;
	/******FK*********/
	//private int oNo;
	private Order order;
	/******FK*********/
	//private int pNo;
	private Product product;
	
}
