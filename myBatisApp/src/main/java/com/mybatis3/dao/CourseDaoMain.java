package com.mybatis3.dao;

public class CourseDaoMain {

	public static void main(String[] args) {
		CourseDao courseDao=new CourseDao();
		System.out.println("-----------findCourseByIdWithStudents----------");
		System.out.println(courseDao.findCourseByIdWithStudents(1));
		System.out.println("-----------findCourseByIdWithTutor----------");
		
		
	}

}
