package com.example.flatfileparser.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.beanio.BeanReader;
import org.beanio.BeanReaderErrorHandlerSupport;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.beanio.builder.FixedLengthParserBuilder;
import org.beanio.builder.StreamBuilder;
import org.springframework.stereotype.Service;

import com.example.flatfileparser.model.GroupRoot;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class FlatFileParserService {

	public void getFile() throws FileNotFoundException {

		try {
			InputStream payload = new FileInputStream(new File("./src/main/resources/sampleFile.txt"));
			GroupRoot beanReader = createBeanReaderFromGroup(GroupRoot.class, payload);
			if (beanReader != null) {
				writeBeanReaderFromGroup(GroupRoot.class, beanReader);
			}
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}

	}

	public void writeBeanReaderFromGroup(Class groupClass, Object obj) {
		StreamFactory factory = StreamFactory.newInstance();
		String streamName = "stream";
		StreamBuilder streamBuilder = new StreamBuilder(streamName).format("fixedlength")
				.parser(new FixedLengthParserBuilder()).addGroup(groupClass);
		factory.define(streamBuilder);

		BeanWriter out = factory.createWriter(streamName, new File("C:\\Users\\vinicius.schulz\\Desktop\\teste.txt"));
		out.write(obj);
		out.flush();
		out.close();
	}

	public <T> T createBeanReaderFromGroup(Class<T> clazz, InputStream payLoad) throws IOException {
		StreamFactory factory = StreamFactory.newInstance();
		String streamName = "stream";
		StreamBuilder streamBuilder = new StreamBuilder(streamName).format("fixedlength")
				.parser(new FixedLengthParserBuilder()).addGroup(clazz);
		factory.define(streamBuilder);
		try (InputStreamReader inputStreamReader = new InputStreamReader(payLoad)) {
			BeanReader beanReader = factory.createReader(streamName, inputStreamReader);
			beanReader.setErrorHandler(new BeanReaderErrorHandlerSupport());
			return (T) beanReader.read();
		}
	}
}
