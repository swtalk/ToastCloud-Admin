package com.toast.exercise.base;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class BaseJobConfig {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	@Qualifier("DefaultDataSource")
	private DataSource defaultDataSource;
	
	@Autowired
	@Qualifier("DefaultSqlSessionFactory")
	private SqlSessionFactory defaultSqlSessionFactory;
	
	@Bean
    public BatchConfigurer batchConfig() {
        return new DefaultBatchConfigurer(defaultDataSource);
    }
	
	public JobBuilderFactory getJobBuilderFactory() {
		return jobBuilderFactory;
	}
	
	public StepBuilderFactory getStepBuilderFactory() {
		return stepBuilderFactory;
	}
	
	public JobLauncher getJobLauncher() {
		return jobLauncher;
	}
	
	public SqlSessionFactory getDefaultSqlSessionFactory() {
		return defaultSqlSessionFactory;
	}

}
