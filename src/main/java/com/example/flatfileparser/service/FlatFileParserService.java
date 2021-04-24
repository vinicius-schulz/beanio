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
			InputStream path = new FileInputStream(new File("input.txt"));
			GroupRoot beanReader = createBeanReaderFromGroup(GroupRoot.class, path);
			if (beanReader != null) {
				writeBeanReaderFromGroup(beanReader, "output.txt");
			}
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}

	}

	public <T> void writeBeanReaderFromGroup(T obj, String path) {
		StreamFactory factory = StreamFactory.newInstance();
		String streamName = "stream";
		StreamBuilder streamBuilder = new StreamBuilder(streamName).format("fixedlength")
				.parser(new FixedLengthParserBuilder()).addGroup(obj.getClass());
		factory.define(streamBuilder);

		BeanWriter out = factory.createWriter(streamName, new File(path));
		out.write(obj);
		out.flush();
		out.close();
	}

	public <T> T createBeanReaderFromGroup(Class<T> clazz, InputStream filePath) throws IOException {
		StreamFactory factory = StreamFactory.newInstance();
		String streamName = "stream";
		StreamBuilder streamBuilder = new StreamBuilder(streamName).format("fixedlength")
				.parser(new FixedLengthParserBuilder()).addGroup(clazz);
		factory.define(streamBuilder);
		try (InputStreamReader inputStreamReader = new InputStreamReader(filePath)) {
			BeanReader beanReader = factory.createReader(streamName, inputStreamReader);
			beanReader.setErrorHandler(new BeanReaderErrorHandlerSupport());
			return (T) beanReader.read();
		}
	}
}
