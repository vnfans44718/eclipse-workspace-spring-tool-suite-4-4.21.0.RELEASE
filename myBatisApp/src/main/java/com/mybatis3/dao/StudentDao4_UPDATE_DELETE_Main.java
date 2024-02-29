package com.mybatis3.dao;

import java.util.Date;

import com.mybatis3.domain.Student;

public class StudentDao4_UPDATE_DELETE_Main {

	public static void main(String[] args) {
		
		StudentDao studentDao = new StudentDao();
		
		/**************************************************
		 UPDATE
		 ***************************************************/
		/*
		 parameterType: DTO,VO,Domain
		 */
		System.out.println("---------updateStudentById---------------------------");
		
		System.out.println("update row count:"+studentDao.updateStudentById(Student.builder()
				                                                              .studId(9)
																			  .name("팔이름")
				                                                              .email("8change@google.com")
				                                                              .phone("888-8888")
				                                                              .dob(new Date())
				                                                              .build()));
		/**************************************************
		 DELETE
		 ***************************************************/
		/*
		parameterType: java.lang.Integer,java.lang.String
		*/
		System.out.println("---------deleteStudentById---------------------------");
		
		System.out.println("delete row count:"+studentDao.deleteStudentById(9));
		
		
	}
}