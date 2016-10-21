package com.toast.exercise.base;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BaseMapper {
	
	@Autowired
	@Qualifier("DefaultSqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	public Object insert(String queryId, Object params) {
		//TODO 로깅 추가
		return sqlSessionTemplate.insert(queryId, params);
	}
	
	public Object update(String queryId, Object params) {
		//TODO 로깅 추가
		return sqlSessionTemplate.update(queryId, params);
	}
	
	public Object delete(String queryId, Object params) {
		//TODO 로깅 추가
		return sqlSessionTemplate.delete(queryId, params);
	}
	
	public Object selectOne(String queryId) {
		//TODO 로깅 추가
		return sqlSessionTemplate.selectOne(queryId);
	}
	
	public Object selectOne(String queryId, Object params) {
		//TODO 로깅 추가
		return sqlSessionTemplate.selectOne(queryId, params);
	}
	
	public Object selectList(String queryId) {
		//TODO 로깅 추가
		return sqlSessionTemplate.selectList(queryId);
	}
	
	public Object selectList(String queryId, Object params) {
		//TODO 로깅 추가
		return sqlSessionTemplate.selectList(queryId, params);
	}

}
