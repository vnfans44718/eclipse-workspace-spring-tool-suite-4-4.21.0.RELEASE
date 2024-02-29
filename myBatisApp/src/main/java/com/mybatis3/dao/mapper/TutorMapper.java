package com.mybatis3.dao.mapper;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.mybatis3.domain.Tutor;

public interface TutorMapper {
	/*
	<select id="findTutorByIdWithCourses"  
			parameterType="int" 
			resultMap="tutorWithCoursesResultMap">
		  SELECT t.tutor_id, t.name as tutor_name, email,course_id, c.name, description, start_date, end_date
	      FROM tutors t 
	      left outer join courses c 
	      on t.tutor_id=c.tutor_id
	      where t.tutor_id=#{tutorId}
	</select>
	 */
	/*
	@ResultMap("tutorWithCoursesResultMap")
	@Select("SELECT t.tutor_id, t.name as tutor_name, email,course_id, c.name, description, start_date, end_date\r\n"
			+ "	      FROM tutors t \r\n"
			+ "	      left outer join courses c \r\n"
			+ "	      on t.tutor_id=c.tutor_id\r\n"
			+ "	      where t.tutor_id=#{tutorId}")
	public Tutor findTutorByIdWithCourses(Integer studId);
	*/
}