package com.mybatis3.dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.dao.mapper.StudentMapper;
import com.mybatis3.domain.Student;

public class StudentDaoMapperInterface {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE = "com.mybatis3.dao.mapper.StudentMapper.";

	public StudentDaoMapperInterface() {
		try {
			InputStream mybatisConfigInputStream = Resources.getResourceAsStream("mybatis-config-mapper-interface.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			this.sqlSessionFactory = sqlSessionFactoryBuilder.build(mybatisConfigInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * resultType Dto
	 */
	public Student findStudentById(Integer studId) {
		/*SqlSession sqlSession = sqlSessionFactory.openSession(true);
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student student = sqlSession.getMapper(studentMapper.fiStudentById(studId));
		sqlSession.close();
		return student;*/
		
		
			SqlSession sqlSession = sqlSessionFactory.openSession(true);
			
			Student student = sqlSession.getMapper(StudentMapper.class).findStudentById(studId);
			sqlSession.close();
			return student;
		
	}

	public List<Student> findAllStudents() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> studentList = studentMapper.findAllStudents();
		sqlSession.close();
		return studentList;
	}
	
	/*
	 * resultMap :  DTO
	 */
	public Student findStudentByIdResultMap(Integer studId) {
		SqlSession sqlSession= 
				sqlSessionFactory.openSession(true);
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		Student student = 
				studentMapper.findStudentByIdResultMap(studId);
		sqlSession.close();
		return student;
	}

	public List<Student> findAllStudentsResultMap() {
		SqlSession sqlSession=
				sqlSessionFactory.openSession(true);
		StudentMapper studentMapper=
				sqlSession.getMapper(StudentMapper.class);
		List<Student> studentList = 
				studentMapper.findAllStudentsResultMap();
		
		sqlSession.close();
		return studentList;
	}
	/*******************************************************************
	 2. SELECT[결과타입이 Wrapper(String)[Wrapper(String) List]객체,Map객체인경우] 
	*******************************************************************/
	/*
	 * resultType :  String,Wrapper,List<Wrapper>,List<String>
	 */
	public String  findStudentNameById(Integer studId) {
		SqlSession sqlSession=
				sqlSessionFactory.openSession(true);
		
		String name=null;
		sqlSession.close();
		return name;
	}
	public List<String> findStudentNameList(){
		SqlSession sqlSession=
				sqlSessionFactory.openSession(true);
		
		List<String> nameList=null;
		sqlSession.close();
		return nameList;
	}
	/*
	 * resultType : Map
	 */
	public HashMap findStudentByIdMap(Integer studId) {
		SqlSession  sqlSession = sqlSessionFactory.openSession();
		HashMap findStudentMap=null;
		
	
		sqlSession.close();
		return findStudentMap;
	}
	
	public List<HashMap> findAllStudentsMapList(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<HashMap> studentMapList=null;
		sqlSession.close();
		return studentMapList;
	}
	/**************************************************
	 3. SELECT[student + address JOIN]( 1 : 1 )
	 **************************************************/
	/*
	 * resultMap : studentWithAddressResultMap
	 */
	public Student findStudentByIdWithAddress(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Student student=sqlSession.getMapper(StudentMapper.class)
				.findStudentByIdWithAddress(studId);
		sqlSession.close();
		return student;
	}

	/*********************************************************
	 4. SELECT[students + course_enrollment (+ course) ] JOIN( 1 : N )
	 ********************************************************/
	/*
	 * resultMap : studentWithCoursesResultMap
	 */
	public Student findStudentByIdWithCourses(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Student student=null;
		sqlSession.close();
		return student;
	}
	/**************************************************
	 5. SELECT[students + address + courses[course_enrollment] JOIN( 1 : 1 : N )
	**************************************************/
	/*
	 * resultMap : studentWithAddressWithCoursesResultMap
	 */
	public Student findStudentByIdWithAddressAndCourses(Integer studId) {
		
		Student student =null;
		return student;
	}
	
	/**************************************************
	 * INSERT
	 ***************************************************/
	/*
	parameterType: DTO,VO,Domain
	*/
	public int insertStudentBySequence(Student student) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int rowCount=sqlSession.getMapper(StudentMapper.class).insertStudentBySequence(student);
		sqlSession.close();
		return rowCount;
	}
	public int insertStudentBySequenceReturnPrimaryKey(Student student) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int rowCount=sqlSession.getMapper(StudentMapper.class)
				.insertStudentBySequenceReturnPrimaryKey(student);
		sqlSession.close();
		return student.getStudId();
	}

	/**************************************************
	 * UPDATE
	 ***************************************************/
	/*
	  parameterType: DTO,VO,Domain
	 */
	public int updateStudentById(Student updateStudent) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int rowCount=0;
		sqlSession.close();
		return rowCount;
	}

	/**************************************************
	 * DELETE
	 ***************************************************/
	/*
	 parameterType: java.lang.Integer,java.lang.String
	 */
	public int deleteStudentById(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int rowCount =0;
		return rowCount;
	}
	
	public int deleteStudentByName(String name) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int rowCount=0;
		sqlSession.close();
		return rowCount;
	}
	public int deleteStudentByNameLike(String name) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int rowCount=0;
		sqlSession.close();
		return rowCount;
	}
	
	
	public List<Student> findStudentByIdRangeParamMap(Map rangeMap){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<Student> studentList=null;
		return studentList;
	}
	public int updateStudentParamMap(Map studentMap){
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int rowCount=0;
		sqlSession.close();
		return rowCount;
	}
	public List<Student> findStudentsThreeParamMap(Map threeStudentMap){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<Student> studentList=null;
		sqlSession.close();
		return studentList;
	}
	

}
