package com.toast.exercise.online.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.toast.exercise.base.BaseController;
import com.toast.exercise.online.service.IItemService;

@Controller
public class ItemController extends BaseController {
	
	@Autowired
	private IItemService itemService;
	
	@RequestMapping(value="/items", method=RequestMethod.GET)
	@ResponseBody
	public List<?> itemList() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		List<?> resultList = itemService.selectItemList(paramMap);
		
		return resultList;
	}
	
	@RequestMapping(value="/items", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertItems(@RequestParam Map<String, Object> paramMap) {
		paramMap = this.getAuditableMap(paramMap);
		int cnt = itemService.insertItems(paramMap);
		
		paramMap.put("cnt", cnt);
		
		return new ResponseEntity<Map<String, Object>>(paramMap, HttpStatus.OK);
	}
	
	@RequestMapping(value="/items/{itemId}", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> updateItem(@PathVariable("itemId") String itemId, @RequestParam Map<String, Object> paramMap) {
		paramMap = this.getAuditableMap(paramMap);
		paramMap.put("itemId", itemId);
		paramMap.put("price", ((String)paramMap.get("price")).replaceAll(",", ""));
		
		int cnt = itemService.updateItems(paramMap);
		
		paramMap.put("cnt", cnt);
		
		return new ResponseEntity<Map<String, Object>>(paramMap, HttpStatus.OK);
	}
	
	@RequestMapping(value="/items", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> deleteItems(@RequestParam(value="deleteIds[]") List<String> deleteIds) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("deleteIds", deleteIds);
		
		int cnt = itemService.deleteItems(paramMap);
		
		paramMap.put("cnt", cnt);
		
		return new ResponseEntity<Map<String, Object>>(paramMap, HttpStatus.OK);
	}
	
	@RequestMapping(value="/itemList")
	public String itemPage() {
		return "itemList";
	}

}