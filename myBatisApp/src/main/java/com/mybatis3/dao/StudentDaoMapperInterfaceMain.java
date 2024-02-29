package com.mybatis3.dao;

import java.util.Date;

import com.mybatis3.domain.Student;

public class StudentDaoMapperInterfaceMain {

	public static void main(String[] args) {
		StudentDaoMapperInterface mapperInterfaceStudentDao=
				new StudentDaoMapperInterface();
		System.out.println("<<<<<<<<<<<<<< StudentMapper Interface를 사용한Dao메쏘드호출 >>>>>>>>>");
		/**************************************************
		1. SELECT[결과타입이 DTO[DTO List] 객체인경우] 
		**************************************************/
		/*
		 resultType :  DTO
		 */
		System.out.println("---------findStudentById-----------------------------");
		System.out.println(mapperInterfaceStudentDao.findStudentById(1));
		System.out.println("---------findAllStudents-----------------------------");
		System.out.println(mapperInterfaceStudentDao.findAllStudents());
		/*
		 resultMap :  DTO
		 */
		System.out.println("---------findStudentByIdResultMap--------------------");
		System.out.println(mapperInterfaceStudentDao.findStudentByIdResultMap(1));
		System.out.println("---------findAllStudentsResultMap--------------------");
		System.out.println(mapperInterfaceStudentDao.findAllStudentsResultMap());
		/**************************************************
		 2. SELECT[결과타입이 Wrapper(String)[Wrapper(String) List]객체인경우] 
		**************************************************/
		System.out.println("---------findStudentByIdResultMap--------------------");
		System.out.println("---------findAllStudentsResultMap--------------------");
		/**************************************************
	 	 3. SELECT[student + address JOIN]( 1 : 1 )
		 **************************************************/
		/*
		 * resultMap : studentWithAddressResultMap
		 */
		System.out.println("---------findStudentByIdWithAddress------------------");
		System.out.println(mapperInterfaceStudentDao.findStudentByIdWithAddress(1));
		//System.out.println(mapperInterfaceStudentDao.findStudentByIdWithAddress(7));
		
		/*********************************************************
		 4. SELECT[students + course_enrollment( + courses)] JOIN( 1 : N )
		 ********************************************************/
		/*
		 * resultMap : studentWithCoursesResultMap
		 */
		System.out.println("---------findStudentByIdWithCourses------------------");
		//System.out.println(mapperInterfaceStudentDao.findStudentByIdWithCourses(1));
		
		/**************************************************
		 5. SELECT[students + address + course_enrollment(+ courses) JOIN( 1 : 1 : N )
		**************************************************/
		/*
		 * resultMap : studentWithAddressAndCoursesResultMap
		 */
		System.out.println("---------findStudentByIdWithAddressAndCourses------------------");
		
		/**************************************************
		INSERT
		***************************************************/
		/*
		parameterType: DTO,VO,Domain
		*/
		System.out.println("---------insertStudentBySequence(Dto)--------------------------");
		int insertRowCount=mapperInterfaceStudentDao.insertStudentBySequence(Student.builder()
				                            .studId(8000)
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
		insertRowCount=mapperInterfaceStudentDao.insertStudentBySequenceReturnPrimaryKey(insertStudent);
		System.out.println(">>> insertRowCount              :"+insertRowCount);
		System.out.println(">>> Student[Dto]     primary key:"+insertStudent.getStudId());
		/**************************************************
		 UPDATE
		 ***************************************************/
		/*
		 parameterType: DTO,VO,Domain
		 */
		System.out.println("---------updateStudentById---------------------------");
		
		/*System.out.println("update row count:"+mapperInterfaceStudentDao.updateStudentById(Student.builder()
				                                                              .studId(8)
																			  .name("팔이름")
				                                                              .email("8change@google.com")
				                                                              .phone("888-8888")
				                                                              .dob(new Date())
				                                                              .build()));*/
		/**************************************************
		 DELETE
		 ***************************************************/
		/*
		parameterType: java.lang.Integer,java.lang.String
		*/
		System.out.println("---------deleteStudentById---------------------------");
		//System.out.println("delete row count:"+mapperInterfaceStudentDao.deleteStudentById(8));
	}

}