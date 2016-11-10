package com.toast.exercise.batch.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.toast.exercise.base.BaseJobConfig;
import com.toast.exercise.batch.listener.SampleStepListener;
import com.toast.exercise.batch.processor.SampleItemProcessor;
import com.toast.exercise.domain.SampleBatchVO;

@Configuration
@EnableBatchProcessing
@EnableScheduling
public class SampleJobConfig extends BaseJobConfig {

	@Scheduled(cron = "0 20 18 * * *")
	public void perform() throws Exception {
		System.out.println("Sample Job Started");

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String dateTimeParam = format.format(date);

		System.out.println("dateTimeParam : " + dateTimeParam);

		JobParameters param = new JobParametersBuilder().addString("BASE_DT", "2016-10")
				.addString("DATE_TIME", dateTimeParam).toJobParameters();

		JobExecution execution = this.getJobLauncher().run(sampleJob(), param);

		System.out.println("Sample Job Ended");
	}

	@Bean
	public Job sampleJob() {
		return this.getJobBuilderFactory().get("ne11624-job").start(sampleDataImportStep()).build();
	}

	@Bean
	public Step sampleDataImportStep() {
		return this.getStepBuilderFactory().get("Step-Sample-Data-Import").<SampleBatchVO, SampleBatchVO> chunk(10)
				.reader(sampleItemReader()).processor(sampleItemProcessor()).writer(sampleItemWriter())
				.listener(sampleStepListener()).build();
	}

	@Bean
	public ItemReader<SampleBatchVO> sampleItemReader() {
		MyBatisPagingItemReader<SampleBatchVO> reader = new MyBatisPagingItemReader<>();
		reader.setSqlSessionFactory(this.getDefaultSqlSessionFactory());
		reader.setQueryId("sampleBatchMapper.selectItems");
		reader.setPageSize(100);

		return reader;
	}

	@Bean
	public ItemProcessor<SampleBatchVO, SampleBatchVO> sampleItemProcessor() {
		return new SampleItemProcessor();
	}

	@Bean
	public ItemWriter<SampleBatchVO> sampleItemWriter() {
		MyBatisBatchItemWriter<SampleBatchVO> writer = new MyBatisBatchItemWriter<>();
		writer.setSqlSessionFactory(this.getDefaultSqlSessionFactory());
		writer.setStatementId("sampleBatchMapper.insertItem");

		return writer;
	}

	@Bean
	public StepExecutionListener sampleStepListener() {
		return new SampleStepListener();
	}
}
