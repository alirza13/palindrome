package com.alirza.microservices.palindrome.processor;

import java.util.ArrayList;
import java.util.List;

import io.micrometer.common.util.StringUtils;

public class PalindromeProcessor {

	public static String getOutputFromString(String input) {
		if (StringUtils.isBlank(input)) {
			return "none";
		}
		int length = input.length();
		int beginningPos, endingPos;
		int middlePos = -1;
		StringBuilder sbBegin = new StringBuilder();
		StringBuilder sbEnd = new StringBuilder();
		if (length % 2 == 0) {
			beginningPos = length / 2;
			endingPos = length / 2;
			middlePos = length / 2;
		} else {
			beginningPos = length / 2 - 1;
			endingPos = length / 2;
		}
		List<String> resultList = new ArrayList<>();
		String result = null;
		while (beginningPos >= 0 && endingPos < length) {
			if (input.charAt(beginningPos) == input.charAt(endingPos)) {
				sbBegin.insert(0, input.charAt(beginningPos));
				if (middlePos != endingPos) {
					sbEnd.append(input.charAt(endingPos));
				}
			} else {
				resultList.add(sbBegin.toString() + sbEnd.toString());
				sbBegin.setLength(0);
				sbEnd.setLength(0);
			}
			beginningPos--;
			endingPos++;
		}
		int maxLength = 0;
		for (String r : resultList) {
			if (r.length() > maxLength) {
				maxLength = r.length();
				result = r;
			}
		}
		return result;
	}

}
