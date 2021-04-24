package com.example.flatfileparser.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.beanio.BeanReader;
import org.beanio.BeanReaderErrorHandlerSupport;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.beanio.builder.FixedLengthParserBuilder;
import org.beanio.builder.StreamBuilder;
import org.springframework.stereotype.Service;

import com.example.flatfileparser.model.DetailsRecord;
import com.example.flatfileparser.model.GroupRoot;
import com.example.flatfileparser.model.HeaderRecord;
import com.example.flatfileparser.model.TX52;
import com.example.flatfileparser.model.TX56;
import com.example.flatfileparser.model.TX57;
import com.example.flatfileparser.model.TX67;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class FlatFileParserService {

	public void readPositionalFile() {

		try {
			InputStream path = new FileInputStream(new File("input.txt"));
			GroupRoot bean = createBeanReaderFromGroup(GroupRoot.class, path);
			log.info(bean);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	public void writePositionalFile() {

		GroupRoot root = new GroupRoot();
		DetailsRecord detailsRecord = new DetailsRecord();

		root.setHeaderRecords(new ArrayList<>());

		detailsRecord.setTx52s(new ArrayList<>());
		detailsRecord.setTx57s(new ArrayList<>());

		root.setDetailsRecord(detailsRecord);

		HeaderRecord headerRecorda = new HeaderRecord();
		HeaderRecord headerRecordb = new HeaderRecord();
		HeaderRecord headerRecordc = new HeaderRecord();

		TX56 tx56a = new TX56();
		TX56 tx56b = new TX56();
		TX56 tx56c = new TX56();
		tx56a.setNumber(866);
		tx56b.setNumber(866);
		tx56c.setNumber(866);

		TX67 tx67a = new TX67();
		TX67 tx67b = new TX67();
		TX67 tx67c = new TX67();
		tx67a.setNumber(972);
		tx67b.setNumber(972);
		tx67c.setNumber(972);

		TX57 tx57a = new TX57();
		TX57 tx57b = new TX57();
		TX57 tx57c = new TX57();
		TX57 tx57d = new TX57();

		tx57a.setNumber(86659);
		tx57b.setNumber(86659);
		tx57c.setNumber(86659);
		tx57d.setNumber(86659);

		TX52 tx52a = new TX52();
		TX52 tx52b = new TX52();
		TX52 tx52c = new TX52();

		tx52a.setNumber(22);
		tx52b.setNumber(22);
		tx52c.setNumber(22);

		headerRecorda.setTx56(tx56a);
		headerRecorda.setTx67(tx67a);

		headerRecordb.setTx56(tx56b);
		headerRecordb.setTx67(tx67b);

		headerRecordc.setTx56(tx56c);
		headerRecordc.setTx67(tx67c);

		root.getHeaderRecords().add(headerRecorda);
		root.getHeaderRecords().add(headerRecordb);
		root.getHeaderRecords().add(headerRecordc);

		detailsRecord.getTx52s().add(tx52a);
		detailsRecord.getTx52s().add(tx52b);
		detailsRecord.getTx52s().add(tx52c);

		detailsRecord.getTx57s().add(tx57a);
		detailsRecord.getTx57s().add(tx57b);
		detailsRecord.getTx57s().add(tx57c);

		writeBeanReaderFromGroup(root, "output.txt");

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
