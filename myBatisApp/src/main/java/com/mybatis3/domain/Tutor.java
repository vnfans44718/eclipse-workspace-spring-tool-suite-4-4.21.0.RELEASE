package com.mybatis3.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/*
 이름       널?       유형           
-------- -------- ------------ 
TUTOR_ID NOT NULL NUMBER(11)   
NAME     NOT NULL VARCHAR2(50) 
EMAIL    NOT NULL VARCHAR2(50) 
PHONE             VARCHAR2(15) 
DOB               DATE         
ADDR_ID           NUMBER(11) 
 */


@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tutor 
{
	private Integer tutorId;
	private String name;
	private String email;
	private String phone;
	private Date dob;	
	private Address address; //FK addr_id
	
	@Default
	private List<Course> courseList = new ArrayList<Course>();

}
