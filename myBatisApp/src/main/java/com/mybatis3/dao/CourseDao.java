package com.mybatis3.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Course;

public class CourseDao {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE = "com.mybatis3.dao.mapper.CourseMapper.";

	public CourseDao() {
		try {
			InputStream mybatisConfigInputStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			this.sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfigInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**************************************************
 	SELECT[courses + students[course_enrollment] JOIN( 1 : N )
	 **************************************************/
	public Course findCourseByIdWithStudents(Integer courseId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Course course=sqlSession.selectOne(NAMESPACE+"findCourseByIdWithStudents",courseId);
		sqlSession.close();
		return course;
	}
	/**************************************************
 	SELECT[courses + tutor JOIN( 1 : 1 )]
	 **************************************************/
	public Course findCourseByIdWithTutor(Integer courseId) {
		
		Course course=null;
	
		return course;
	}

}