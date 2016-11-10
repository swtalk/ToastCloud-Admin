package com.toast.exercise.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.toast.exercise.base.BaseBatchItemProcessor;
import com.toast.exercise.domain.SampleBatchVO;

public class SampleItemProcessor extends BaseBatchItemProcessor implements ItemProcessor<SampleBatchVO, SampleBatchVO> {

	public SampleBatchVO process(SampleBatchVO sampleBatchVO) throws Exception {
		
			
			sampleBatchVO.setItemId(sampleBatchVO.getItemId() + "-NE11624");
			sampleBatchVO.setItemName(sampleBatchVO.getItemName() + "-NE11624");
			sampleBatchVO.setCreatedId("NE11624");
			
			System.out.println("Converting (" + sampleBatchVO + ") into (" + sampleBatchVO + ")");
			
			return sampleBatchVO;
		}
}
