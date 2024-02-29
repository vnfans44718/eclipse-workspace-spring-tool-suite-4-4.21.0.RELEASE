package com.mybatis3.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Tutor;

public class TutorDao 
{
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE="com.mybatis3.dao.mapper.TutorMapper.";
	public TutorDao() {
		try {
			InputStream mybatisConfigInputStream = 
					Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
			this.sqlSessionFactory = 
					sqlSessionFactoryBuilder.build(mybatisConfigInputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*****************************************
	SELECT  TUTOR + COURSES JOIN [ 1 : N ]
	*****************************************/
	public Tutor findTutorByIdWithCourses(Integer tutorId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Tutor tutor=sqlSession.selectOne(NAMESPACE+"findTutorByIdWithCourses",tutorId);
		sqlSession.close();
		return tutor;
	}
	
}