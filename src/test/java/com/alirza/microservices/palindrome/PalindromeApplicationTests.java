package com.alirza.microservices.palindrome;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.alirza.microservices.palindrome.processor.PalindromeProcessor;

@SpringBootTest
class PalindromeApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(PalindromeProcessor.getOutputFromString("helloracecarsell"));
		assertEquals(PalindromeProcessor.getOutputFromString("helloracecarsell"), "racecar");
	}

}
