package com.example.flatfileparser.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.beanio.BeanReader;
import org.beanio.BeanReaderErrorHandlerSupport;
import org.beanio.StreamFactory;
import org.beanio.builder.FixedLengthParserBuilder;
import org.beanio.builder.StreamBuilder;
import org.springframework.stereotype.Service;

import com.example.flatfileparser.model.WrapperObject;

@Service
public class FlatFileParserService {

	public void getFile() throws FileNotFoundException {
		InputStream payload = new FileInputStream(new File("./src/main/resources/sampleFile.txt"));
		BeanReader beanReader = createBeanReaderFromGroup(WrapperObject.class, payload);

		Object obj = beanReader.read();
		WrapperObject rec = null;
		if (obj != null) {
			rec = (WrapperObject) obj;
		}
		System.out.println(rec);

	}

	public BeanReader createBeanReaderFromGroup(Class groupClass, InputStream payLoad) {
		StreamFactory factory = StreamFactory.newInstance();
		String streamName = "stream";
		StreamBuilder streamBuilder = new StreamBuilder(streamName).format("fixedlength")
				.parser(new FixedLengthParserBuilder()).addGroup(groupClass);
		factory.define(streamBuilder);
		InputStreamReader inputStreamReader = new InputStreamReader(payLoad);
		BeanReader beanReader = factory.createReader(streamName, inputStreamReader);
		beanReader.setErrorHandler(new BeanReaderErrorHandlerSupport());
		return beanReader;
	}
}
