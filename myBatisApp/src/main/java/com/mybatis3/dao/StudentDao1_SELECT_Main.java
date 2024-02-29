package com.mybatis3.dao;
public class StudentDao1_SELECT_Main {
	public static void main(String[] args) {
		StudentDao studentDao = 
				new StudentDao();
		/**************************************************
		1. SELECT[결과타입이 DTO[DTO List] 객체인경우] 
		**************************************************/
		/*
		 resultType :  DTO
		 */
		System.out.println("---------findStudentById-----------------------------");
		//System.out.println(studentDao.findStudentById(1));
		System.out.println("---------findAllStudents-----------------------------");
		//System.out.println(studentDao.findAllStudents());
		/*
		 resultMap :  DTO
		 */
		System.out.println("---------findStudentByIdResultMap--------------------");
		System.out.println(studentDao.findStudentByIdResultMap(1));
		System.out.println("---------findAllStudentsResultMap--------------------");
		//System.out.println(studentDao.findAllStudentsResultMap());
		/**************************************************
		 2. SELECT[결과타입이 Wrapper(String)[Wrapper(String) List]객체인경우] 
		**************************************************/
		System.out.println("---------findStudentByIdResultMap--------------------");
		System.out.println("---------findAllStudentsResultMap--------------------");
	}
}