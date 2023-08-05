package com.alirza.microservices.palindrome.processor;

import io.micrometer.common.util.StringUtils;

public class PalindromeProcessor {
	static int beginningPos, endingPos;
	static int middlePos = -1;

	public static String getOutputFromString(String input) {
		if (StringUtils.isBlank(input)) {
			return "none";
		}
		int maxLength = 0;
		int begin = 0;
		for (int i = 0; i < input.length(); i++) {
			int first = getMaxLength(input, i, i);
			int second = getMaxLength(input, i, i + 1);
			int tempMax = Math.max(first, second);
			if (tempMax > maxLength) {
				maxLength = tempMax;
				begin = i - maxLength / 2;
			}
		}

		return input.substring(begin + 1, begin + maxLength);
	}

	public static int getMaxLength(String input, int beginningPos, int endingPos) {
		int length = input.length();
		while (beginningPos >= 0 && endingPos < length) {
			if (input.charAt(beginningPos) == input.charAt(endingPos)) {
				beginningPos--;
				endingPos++;
			} else {
				break;
			}
		}
		return endingPos - beginningPos;
	}

}
