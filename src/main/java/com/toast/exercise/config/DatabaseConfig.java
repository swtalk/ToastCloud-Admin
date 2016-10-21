package com.toast.exercise.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class DatabaseConfig {
	
	@Bean(name = "DefaultDataSource")
	@Qualifier("DefaultDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.default")
	public DataSource defalutDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "DefaultSqlSessionFactory")
	@Qualifier("DefaultSqlSessionFactory")
	@Primary
	public SqlSessionFactory defaultSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(defalutDataSource());
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mappers/*.xml"));
		
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean(name = "DefaultSqlSessionTemplate")
	@Qualifier("DefaultSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate defaultSqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(defaultSqlSessionFactory());
	}
	
}
