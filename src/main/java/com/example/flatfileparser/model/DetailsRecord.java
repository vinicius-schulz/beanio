package com.example.flatfileparser.model;

import java.util.List;

import org.beanio.annotation.Record;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DetailsRecord {
	@Record(name = "TX57", minOccurs = 1, maxLength = 8)
	private List<TX57> tx57s;

	@Record(maxLength = 5, name = "TX52", minOccurs = 1)
	private List<TX52> tx52s;

}
