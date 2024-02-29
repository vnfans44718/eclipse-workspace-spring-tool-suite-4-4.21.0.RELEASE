package com.itwill.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * VO(Value Object),DTO(Data Transfer Object)
 * 	- address 테이블 1개 row의 데이타의 값을 가지는객체
 *  - address 테이블 1개 row의 데이타값을 전달(파라메타,리턴데이타)시키기위한객체
 *  - address 테이블의 컬럼과 동일한수의 멤버필드를 가지는객체
 */
/*
이름      널?       유형           
------- -------- ------------ 
NO      NOT NULL NUMBER(4)    
NAME             VARCHAR2(50) 
PHONE            VARCHAR2(50) 
ADDRESS          VARCHAR2(60)
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Address {
	private int no;
	private String name;
	private String phone;
	private String address;
	
}
