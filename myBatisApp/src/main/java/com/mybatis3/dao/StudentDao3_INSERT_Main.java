package com.mybatis3.dao;

import java.util.Date;

import com.mybatis3.domain.Student;

public class StudentDao3_INSERT_Main {

	public static void main(String[] args) {
		
		StudentDao studentDao = new StudentDao();
		/**************************************************
		INSERT
		***************************************************/
		/*
		parameterType: DTO,VO,Domain
		*/
		System.out.println("---------insertStudentBySequence(Dto)--------------------------");
		int insertRowCount=studentDao.insertStudentBySequence(Student.builder()
											.name("시퀀스1")
											.phone("100-10000")
											.email("kim@naver.com")
											.dob(new Date())
											.build());
		System.out.println(">>> dao return insertRowCount:"+insertRowCount);
		System.out.println("---------insertStudentBySequenceReturnPrimaryKey---------------");
		Student insertStudent=Student.builder()
				.studId(9000)
				.name("시퀀스2")
				.phone("200-20000")
				.email("kim2@naver.com")
				.dob(new Date())
				.build();
		insertRowCount=studentDao.insertStudentBySequenceReturnPrimaryKey(insertStudent);
		System.out.println(">>> insertRowCount              :"+insertRowCount);
		System.out.println(">>> Student[Dto]     primary key:"+insertStudent.getStudId());
		
		
		
		
	}
}