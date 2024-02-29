package com.itwill.shop.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
VO(Value Object),DTO(Data Transfer Object)
	- cart 테이블 1개 row의 데이타의 값을 가지는객체
	- cart 테이블 1개 row의 데이타값을 이동(파라메타,리턴데이타)시키기위한객체 
	- cart 테이블의 컬럼과 동일한수의 멤버변수를가지는객체

이름       널?       유형            
-------- -------- ------------- 
CART_NO  NOT NULL NUMBER(10)    //PK
USERID            VARCHAR2(100) //FK
P_NO              NUMBER(10)    //FK
CART_QTY          NUMBER(10)  	
	
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {
	private int cartNo;
	/********FK**********/
	//private String userid;
	private User user;
	/*******FK***********/
	//private int pNo;
	private Product product;
	
	private int cartQty;
}
