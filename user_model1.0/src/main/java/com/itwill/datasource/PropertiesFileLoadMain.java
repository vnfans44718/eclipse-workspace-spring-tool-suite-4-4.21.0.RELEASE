package com.itwill.datasource;

import java.io.FileInputStream;
import java.util.Properties;

import com.itwill.user.UserDao;

public class PropertiesFileLoadMain {

	public static void main(String[] args) throws Exception{
		Properties properties=new Properties();
		/*********************application.properties******************
		spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
		spring.datasource.url=jdbc:oracle:thin:@124.198.47.195:1521:xe
		spring.datasource.username=jdeveloper30
		spring.datasource.password=jdeveloper30
		***************************************************************/
		/*
		jdbc.properties 파일을 loading해서 Properties객체[HashMap]를 만들어준다.
		 */
		
	}

}
