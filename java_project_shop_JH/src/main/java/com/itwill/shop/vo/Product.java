package com.itwill.shop.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
VO(Value Object),DTO(Data Transfer Object)
	- product 테이블 1개 row의 데이타의 값을 가지는객체
	- product 테이블 1개 row의 데이타값을 이동(파라메타,리턴데이타)시키기위한객체 
	- product 테이블의 컬럼과 동일한수의 멤버변수를가지는객체
*/
/*
이름            널?       유형            
------------- -------- ------------- 
P_NO          NOT NULL NUMBER(10)    
P_NAME                 VARCHAR2(50)  
P_PRICE                NUMBER(10)    
P_IMAGE                VARCHAR2(50)  
P_DESC                 VARCHAR2(512) 
P_CLICK_COUNT          NUMBER(10)    
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
	private int pNo;
	private String pName;
	private int pPrice;
	private String pImage;
	private String pDesc;
	private int pClickCount;
}
