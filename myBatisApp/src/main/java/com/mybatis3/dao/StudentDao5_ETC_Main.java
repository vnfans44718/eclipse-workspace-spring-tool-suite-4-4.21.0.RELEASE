package com.mybatis3.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mybatis3.domain.Student;

public class StudentDao5_ETC_Main {

	public static void main(String[] args) {
		
		StudentDao studentDao = new StudentDao();
		System.out.println("---------findStudentNameList----------");
		System.out.println("### "+studentDao.findStudentNameList());
		System.out.println("---------findStudentNameById----------");
		System.out.println("### "+studentDao.findStudentNameById(1));
		System.out.println("-------findStudentByIdMap-------");
		Map sMap=studentDao.findStudentByIdMap(1);
		System.out.println("### "+sMap);
		System.out.println("### "+sMap.get("STUDID"));
		System.out.println("### "+sMap.get("NAME"));
		System.out.println("### "+sMap.get("PHONE"));
		System.out.println("### "+sMap.get("EMAIL"));
		System.out.println("### "+sMap.get("DOB"));
		
		System.out.println("------------findAllStudentsMapList-------------");
		List<HashMap> studentMapList=studentDao.findAllStudentsMapList();
		System.out.println("### "+studentMapList);
		for (HashMap studentMap : studentMapList) {
			System.out.println(studentMap.get("STUDID")+"\t"+studentMap.get("NAME"));
		}
		System.out.println("---------updateStudentParamMap(parameter Map)----");
		HashMap studentMap=new HashMap();
		studentMap.put("studId",1);
		studentMap.put("name","유노유노");
		studentMap.put("email","you@no.co.kr");
		studentMap.put("dob",new Date());
		System.out.println("### "+studentDao.updateStudentParamMap(studentMap));
		System.out.println("---------findStudentByIdRangeParamMap(parameter Map)----");
		HashMap rangeMap=new HashMap();
		rangeMap.put("startNo", 1);
		rangeMap.put("endNo", 3);
		System.out.println("### "+studentDao.findStudentByIdRangeParamMap(rangeMap));
		System.out.println("---------findStudentsThreeParamMap(parameter Map)----");
		Student firstStudent=new Student(1,null,null,null,null,null,null);
		Student secondStudent=new Student(3,null,null,null,null,null,null);
		Student thirdStudent=new Student(5,null,null,null,null,null,null);
		HashMap threeStudentMap=new HashMap();
		threeStudentMap.put("first", firstStudent);
		threeStudentMap.put("second", secondStudent);
		threeStudentMap.put("third", thirdStudent);
		System.out.println("### "+studentDao.findStudentsThreeParamMap(threeStudentMap));
		
		
		
		
	}
}