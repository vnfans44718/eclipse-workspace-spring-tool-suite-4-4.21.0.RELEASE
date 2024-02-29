package com.itwill.datasource;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.itwill.user.UserDao;
public class BasicDataSourceExample {
	public static void main(String[] args) throws Exception {
		/****************org.apache.tomcat.dbcp.dbcp2.BasicDataSource**********/
		BasicDataSource basicDataSource=new BasicDataSource();
		Properties properties=new Properties();
		/***************[jdbc.properties]***********************
		spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
		spring.datasource.url=jdbc:oracle:thin:@124.198.47.195:1521:xe
		spring.datasource.username=jdeveloper30
		spring.datasource.password=jdeveloper30
		**************************************************************/
		properties.load(UserDao.class.getResourceAsStream("/jdbc.properties"));
		basicDataSource.setDriverClassName(properties.getProperty("spring.datasource.driver-class-name"));
		basicDataSource.setUrl(properties.getProperty("spring.datasource.url"));
		basicDataSource.setUsername(properties.getProperty("spring.datasource.username"));
		basicDataSource.setPassword(properties.getProperty("spring.datasource.password"));
		
		
		/******************** << javax.sql.DataSource >> **************************/
		DataSource dataSource=basicDataSource;
		Connection con=dataSource.getConnection();
		System.out.println(con);
		con.close();
		/************************************************************************/
		
	}

}
