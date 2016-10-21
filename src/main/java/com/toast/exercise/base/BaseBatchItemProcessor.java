package com.toast.exercise.base;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BaseBatchItemProcessor {
	
	@Autowired
	@Qualifier("DefaultSqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	public SqlSessionTemplate getDefaultSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

}
