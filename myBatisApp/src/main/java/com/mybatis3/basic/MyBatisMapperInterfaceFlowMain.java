package com.mybatis3.basic;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.dao.mapper.StudentBasicMapper;
import com.mybatis3.dao.mapper.StudentMapper;

public class MyBatisMapperInterfaceFlowMain {

	public static void main(String[] args) throws Exception {
		/*
		 * 0.mybatis-config-mapper-interface.xml --> InputStream
		 */
		InputStream mybatisConfigInputStream = Resources.getResourceAsStream("mybatis-config-mapper-interface.xml");

		/*
		 * 1. SqlSessionFactoryBuilder
		 */
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

		/*
		 * 2. SqlSessionFactory(sqlSession 공장)
		 */
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfigInputStream);
		/*
		 * 3. SqlSession open (Connection) autocommit true
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		/*
		 * xml의 mapper 로딩 <mappers> <mapper
		 * class="com.mybatis3.dao.mapper.StudentBasicMapper"/> </mappers> 이미 mapper는
		 * 만들어져있고
		 */
		System.out.println("### SqlSession 객체" + sqlSession);

		/*
		 * 4. StudentMapper[MapperInterface]생성 org.apache.ibatis.binding.MapperProxy
		 * MapperProxy는 내가 만든 StudentBasicMapper의 자식이다. StudentBasicMapper의 메소드를 구현하고
		 * 있다.
		 * 인터페이스는 객체가 없다
		 */
		StudentBasicMapper studentBasicMapper = sqlSession.getMapper(StudentBasicMapper.class);

		System.out.println("### StudentsBasicMapper 객체" + studentBasicMapper);

		/*
		 * 4. StudentMapper[MapperInterface]사용(CRUD)
		 */
		System.out.println(studentBasicMapper.findAllStudents());
		System.out.println(studentBasicMapper.findStudentById(1));

		/*
		 * 5. SqlSession close
		 */
		sqlSession.close();

	}
}
