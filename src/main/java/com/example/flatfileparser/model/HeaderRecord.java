package com.example.flatfileparser.model;

import org.beanio.annotation.Record;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HeaderRecord {

	@Record(maxLength = 6, name = "TX56", minOccurs = 1, maxOccurs = 1)
	private TX56 tx56;

	@Record(maxLength = 6, name = "TX67", minOccurs = 1, maxOccurs = 1)
	private TX67 tx67;
}