package com.alirza.microservices.palindrome.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@ConfigurationProperties("palindrome-services")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Configuration {
	private String input;
}
