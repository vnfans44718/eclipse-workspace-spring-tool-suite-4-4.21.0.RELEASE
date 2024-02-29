package com.mybatis3.dao;

public class TutorDaoMain {

	public static void main(String[] args) {
		TutorDao tutorDao=new TutorDao();
		System.out.println("----------findTutorByIdWithCourses--------");
		System.out.println(tutorDao.findTutorByIdWithCourses(1));
	
	}
}