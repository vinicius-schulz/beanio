package com.example.flatfileparser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flatfileparser.service.FlatFileParserService;

@RestController
@RequestMapping("fileconversion")
public class FlatFileParserController {

	private final FlatFileParserService flatFileParserService;

	@Autowired
	public FlatFileParserController(FlatFileParserService flatFileParserService) {
		this.flatFileParserService = flatFileParserService;
	}

	@GetMapping(value = "read")
	public void readFile() {
		flatFileParserService.readPositionalFile();
	}

	@GetMapping(value = "write")
	public void writeFile() {
		flatFileParserService.writePositionalFile();
	}

}
