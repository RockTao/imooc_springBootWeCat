package com.imooc.config.dao;

import java.beans.PropertyVetoException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
//配置mybatis  mapper 的扫描路劲
@MapperScan("com.imooc.dao")
public class DataSourceConfiguration {
	@Value("${jdbc.driver}")
	String jdbcDriver;
	@Value("${jdbc.jdbcUrl}")
	String jdbcUrl;
	@Value("${jdbc.user}")
	String jdbcUsername;
	@Value("${jdbc.password}")
	String jdbcPassword;
	
	@Bean(name="dataSource")
	public ComboPooledDataSource createDataSource() throws Exception {
		ComboPooledDataSource dataSource= new ComboPooledDataSource();
		dataSource.setDriverClass(jdbcDriver);
		dataSource.setJdbcUrl(jdbcUrl);
		dataSource.setUser(jdbcUsername);
		dataSource.setPassword(jdbcPassword);
		//关闭连接后不自动commit
		dataSource.setAutoCommitOnClose(false);
		return dataSource;
		
	}

}
