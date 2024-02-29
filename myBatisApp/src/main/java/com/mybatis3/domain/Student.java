package com.mybatis3.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
이름      널?       유형           
------- -------- ------------ 
STUD_ID NOT NULL NUMBER(11)   
NAME    NOT NULL VARCHAR2(50) 
EMAIL   NOT NULL VARCHAR2(50) 
PHONE            VARCHAR2(15) 
DOB              DATE         
BIO              CLOB         
PIC              BLOB         
ADDR_ID          NUMBER(11)   
*/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@RequiredArgsConstructor
public class Student {
	private Integer studId;
	private String name;
	private String email;
	private String phone;
	private Date dob;
	private Address address;//FK
	@Default
	private List<Course> courseList=
			new ArrayList<Course>();
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", name=" + name + ", email=" + email + ", phone=" + phone + ", dob=" + dob
				+ ", address=" + address + ", courseList=" + courseList + "]\n";
	}
	
	
}