package com.mybatis3.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.mybatis3.domain.Student;

public interface StudentMapper {
	/*
	 * 인터페이스의 풀네임은 StudentMapper.xml의 namespace와일치(패키지 경로가 같다)
	 * 메쏘드이름은 	StudentMapper.xml 파일의 id와일치
	 * 메쏘드인자타입은 StudentMapper.xml 파일의 parameterType 와일치
	 * 메쏘드리턴타입은 StudentMapper.xml 파일의 resultType 와일치(ResultSet이 1개이상일경우는 List)
	 */
	
	
	/**************************************************
	1. SELECT[결과타입이 DTO[DTO List] 객체인경우] 
	**************************************************
	resultType :  DTO
	*/
	@ResultType(Student.class)
	@Select("select stud_id ,name,phone,email,dob from students where stud_id=#{studId}")
	Student findStudentById(@Param("studId") Integer studId);
	
	@ResultType(Student.class)
	@Select("select stud_id , name,phone,email,dob from students")
	List<Student> findAllStudents();
	/*
	resultMap :  DTO
	 */
	@Results({
		@Result(column = "STUD_ID" ,property = "studId",id = true),
		@Result(column = "NAME" ,property = "name"),
		@Result(column = "EMAIL" ,property = "email"),
		@Result(column = "PHONE" ,property = "phone"),
		@Result(column = "DOB" ,property = "dob"),
		@Result(column = "ADDR_ID" ,property = "address", 
		one = @One(select = "com.mybatis3.dao.mapper.AddressMapper.findAddressById"))
	})
	@Select("select stud_id,name,phone,email,dob from students where stud_id=#{studId}")
	public Student findStudentByIdResultMap(@Param("studId") Integer studId);
	
	@ResultMap("studentResultMap")
	@Select("select stud_id,name,email,phone,dob from students")
	public List<Student> findAllStudentsResultMap();
	
	
	/*******************************************************************
	 2. SELECT[결과타입이 Wrapper(String)[Wrapper(String) List]객체인경우] 
	*******************************************************************/
	
	String findStudentNameById(Integer studId);
	List<String> findStudentNameList();
	
	
	
	/**************************************************
	 3. SELECT[student + address JOIN]( 1 : 1 )
	 **************************************************/
	
	@ResultMap("studentResultMap")
	@Select("select stud_id, name, email,dob, a.addr_id, street, city, state, zip, country\r\n"
			+ "		FROM students s \r\n"
			+ "		left outer join addresses a \r\n"
			+ "		on s.addr_id=a.addr_id where stud_id=#{studId}")
	Student findStudentByIdWithAddress(Integer studId);
	
	/*@Results({
		@Result(column = "STUD_ID" ,property = "studId",id = true),
		@Result(column = "NAME" ,property = "name"),
		@Result(column = "EMAIL" ,property = "email"),
		@Result(column = "PHONE" ,property = "phone"),
		@Result(column = "DOB" ,property = "dob"),
		@Result(column = "ADDR_ID" ,property = "address", 
		one = @One(select = "com.mybatis3.dao.mapper.AddressMapper.findAddressById"))
	})
	@Select("select * from students where stud_id=#{studId}")
	Student findStudentByIdWithAddress(Integer studId);*/
	

	/*********************************************************
	 4. SELECT[students + courses[course_enrollment]+course] JOIN( 1 : N )
	 ********************************************************/
	Student findStudentByIdWithCourses(Integer studId);

	/**************************************************
	 5. SELECT[students + address + courses[course_enrollment] JOIN( 1 : 1 : N )
	**************************************************/
	Student findStudentByIdWithAddressAndCourses(Integer studId);

	/**************************************************
	 * INSERT
	 ***************************************************/
	
	@Insert("insert into students(stud_id,name,phone,email,dob)\r\n"
			+ "		values (students_stud_id_seq.nextval,#{name},#{email},#{phone},#{dob})")
	int insertStudentBySequence(Student student);
	
	@SelectKey(before = true, resultType =Integer.class ,keyProperty = "studId"
			, statement = "select students_stud_id_seq.nextval from dual")
	@Insert("insert into students(stud_id,name,phone,email,dob)\r\n"
			+ "		values (#{studId},#{name},#{email},#{phone},#{dob})")
	int insertStudentBySequenceReturnPrimaryKey(Student student);
	/*param을 주면 student.studId 써줘야함 */
	/**************************************************
	 * UPDATE
	 ***************************************************/
	int updateStudentById(Student updateStudent);
	/**************************************************
	 * DELETE
	 ***************************************************/
	int deleteStudentById(Integer studId);
	int deleteStudentByName(String name);
	int deleteStudentByNameLike(String name);
	
	
	
	
	
}
