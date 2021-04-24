package com.example.flatfileparser.model;

import org.beanio.annotation.Field;
import org.beanio.builder.Align;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TX57 {

	@Field(ordinal = 0, at = 0, length = 2, rid = true, literal = "57", trim = true)
	private int id;
	@Field(ordinal = 1, at = 2, length = 6, trim = true, padding = '0', align = Align.RIGHT)
	private int number;
}
