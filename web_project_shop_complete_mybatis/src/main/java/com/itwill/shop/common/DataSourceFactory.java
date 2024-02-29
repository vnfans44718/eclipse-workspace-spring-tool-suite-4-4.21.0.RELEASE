package com.itwill.shop.common;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;



public class DataSourceFactory {
	private static DataSource _dataSource;
	private DataSourceFactory() {
		
	}
	
	public static  DataSource getDataSource() throws Exception{
		if(_dataSource==null) {
			Properties properties = new Properties();
			properties.load(DataSourceFactory.class.getResourceAsStream("/jdbc.properties"));
			BasicDataSource basicDataSource = new BasicDataSource();
			basicDataSource.setDriverClassName(properties.getProperty("jdbc.driverClassName"));
			basicDataSource.setUrl(properties.getProperty("jdbc.url"));
			basicDataSource.setUsername(properties.getProperty("jdbc.username"));
			basicDataSource.setPassword(properties.getProperty("jdbc.password"));
			_dataSource = basicDataSource;
		}
		return _dataSource;
	}
	
}
