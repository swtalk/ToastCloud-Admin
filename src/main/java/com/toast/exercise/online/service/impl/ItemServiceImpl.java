package com.toast.exercise.online.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toast.exercise.mapper.ItemMapper;
import com.toast.exercise.online.service.IItemService;

@Service
public class ItemServiceImpl implements IItemService {
	
	@Autowired
	private ItemMapper itemMapper;
	
	@Override
	public List<?> selectItemList(Map<String, Object> paramMap) {
		List<?> resultList = itemMapper.selectItemList(paramMap);
		
		return resultList;
	}
	
	@Override
	public int insertItems(Map<String, Object> paramMap) {
		int cnt = itemMapper.insertItems(paramMap);
		
		return cnt;
	}
	
	@Override
	public int updateItems(Map<String, Object> paramMap) {
		int cnt = itemMapper.updateItem(paramMap);
		
		return cnt;
	}
	
	@Override
	public int deleteItems(Map<String, Object> paramMap) {
		int cnt = itemMapper.deleteItems(paramMap);
		
		return cnt;
	}

}