package com.toast.exercise.online.service;

import java.util.List;
import java.util.Map;

public interface IItemService {

	public List<?> selectItemList(Map<String, Object> paramMap);

	public int insertItems(Map<String, Object> paramMap);

	public int updateItems(Map<String, Object> paramMap);
	public int deleteItems(Map<String, Object> paramMap);
}