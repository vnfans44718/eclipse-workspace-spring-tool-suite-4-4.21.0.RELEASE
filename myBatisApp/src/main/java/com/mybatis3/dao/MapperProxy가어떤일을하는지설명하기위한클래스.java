package com.mybatis3.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis3.dao.mapper.StudentBasicMapper;
import com.mybatis3.dao.mapper.StudentMapper;
import com.mybatis3.domain.Student;

public class MapperProxy가어떤일을하는지설명하기위한클래스 implements StudentBasicMapper{
	private SqlSession sqlSession;
	@Override
	public Student findStudentById(Integer studId) {
		String namespace = StudentBasicMapper.class.getName();
		Student student=sqlSession.selectOne(namespace+".findStudentById",studId);
		sqlSession.commit();
		sqlSession.close();
		return student;
	}

	@Override
	public List<Student> findAllStudents() {
		String namespace = StudentMapper.class.getName();
		sqlSession.selectList(namespace+".findAllStudents");
		return null;
	}

}