package com.alirza.microservices.palindrome.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alirza.microservices.palindrome.configuration.Configuration;
import com.alirza.microservices.palindrome.dto.PalindromeDto;
import com.alirza.microservices.palindrome.processor.PalindromeProcessor;

@RestController
public class PalindromeController {
	@Autowired
	private Configuration configuration;

	@GetMapping("/get-palindrome-cloud")
	public List<PalindromeDto> getPalindromeCloud() {
		List<PalindromeDto> palindromeDtoList = new ArrayList<>();
		String[] inputArr = configuration.getInput().split(",");
		for (String s : inputArr) {
			palindromeDtoList
					.add(PalindromeDto.builder().input(s).output(PalindromeProcessor.getOutputFromString(s)).build());
		}
		return palindromeDtoList;

	}

	@GetMapping("/get-palindrome/input/{input}")
	public PalindromeDto getPalindrome(@PathVariable String input) {
		return PalindromeDto.builder().input(input).output(PalindromeProcessor.getOutputFromString(input)).build();
	}

}
