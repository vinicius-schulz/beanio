package com.example.flatfileparser.model;

import java.util.List;

import org.beanio.annotation.Group;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Group
@Getter
@Setter
@ToString
public class GroupRoot {

	@Group(order = 1, maxOccurs = 3)
	private List<HeaderRecord> headerRecords;
	
	@Group(order = 2)
	private DetailsRecord detailsRecord;


}