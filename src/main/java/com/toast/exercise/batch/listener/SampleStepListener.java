package com.toast.exercise.batch.listener;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.StepExecution;

import com.toast.exercise.base.BaseStepExecutionListener;

public class SampleStepListener extends BaseStepExecutionListener {
	
	@Override
	public void beforeStep(StepExecution stepExecution) {
		// 테이블 정보 삭제
		Map<String, String> param = new HashMap<String, String>();
		param.put("itemId", "%본인사번");
		
		int cnt = this.getDefaultSqlSessionTemplate().delete("sampleBatchMapper.deleteItems", param);
		System.out.println("cnt : " + cnt);
	}

}