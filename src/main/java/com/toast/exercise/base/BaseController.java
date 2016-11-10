package com.toast.exercise.base;

import java.util.HashMap;
import java.util.Map;

public class BaseController {

	public Map<String, Object> getAuditableMap(Map<String, Object> paramMap) {
		Map<String, Object> auditableMap = new HashMap<String, Object>();
		auditableMap.putAll(paramMap);

		auditableMap.put("userId", "admin");

		return auditableMap;
	}

}