package com.mybatis3.dao;

public class StudentDao2_SELECT_JOIN_Main {

	public static void main(String[] args) {
		
		StudentDao studentDao = new StudentDao();
		/**************************************************
	 	 3. SELECT[student + address JOIN]( 1 : 1 )
		 **************************************************/
		/*
		 * resultMap : studentWithAddressResultMap
		 */
		System.out.println("---------findStudentByIdWithAddress------------------");
		System.out.println(studentDao.findStudentByIdWithAddress(1));
		System.out.println(studentDao.findStudentByIdWithAddress(7));
		
		/*********************************************************
		 4. SELECT[students + course_enrollment( + courses)] JOIN( 1 : N )
		 ********************************************************/
		/*
		 * resultMap : studentWithCoursesResultMap
		 */
		System.out.println("---------findStudentByIdWithCourses------------------");
		System.out.println(studentDao.findStudentByIdWithCourses(1));
		
		/**************************************************
		 5. SELECT[students + address + course_enrollment(+ courses) JOIN( 1 : 1 : N )
		**************************************************/
		/*
		 * resultMap : studentWithAddressAndCoursesResultMap
		 */
		System.out.println("---------findStudentByIdWithAddressAndCourses------------------");
		
		
	}
}