package com.toast.exercise.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.toast.exercise.base.BaseMapper;

@Repository("itemMapper")
public class ItemMapper extends BaseMapper {
	
	public List<?> selectItemList(Map<String, Object> paramMap) {
		
		return (List<?>) selectList("itemMapper.selectItemList", paramMap);
	}
	
	public int insertItems(Map<String, Object> paramMap) {
		return (int) insert("itemMapper.insertItems", paramMap);
	}
	
	public int updateItem(Map<String, Object> paramMap) {
		return (int) update("itemMapper.updateItem", paramMap);
	}
	public int deleteItems(Map<String, Object> paramMap) {
		return (int) delete("itemMapper.deleteItems", paramMap);
	}
	
}