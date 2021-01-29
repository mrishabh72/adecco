package code;

import java.util.regex.Pattern;

public class StringCalculator {

	private static String ERROR_MESSAGE = "negatives not allowed - ";

	public int add(String numbers) {
		int sum = 0;
		String delimiter = ",";
		String errMsg = ERROR_MESSAGE;

		if (numbers.startsWith("//[")) {
			delimiter = numbers.substring(3, numbers.indexOf("]"));
			numbers = numbers.substring(4 + delimiter.length());
		} else if (numbers.startsWith("//")) {
			delimiter = numbers.substring(2, numbers.indexOf("\n"));
			numbers = numbers.substring(2 + delimiter.length());
		}
		Pattern pattern = Pattern.compile(delimiter, Pattern.LITERAL);
		String[] line = numbers.split("\n");
		for (String str : line) {
			if (!str.isEmpty()) {
				String[] strs = pattern.split(str);
				for (String strNum : strs) {
					int num = Integer.parseInt(strNum);
					if (num >= 0 && num <= 1000) {
						sum += num;
					} else if (num < 0) {
						errMsg += num + ",";
					}
				}
			}
		}
		if (!errMsg.equals(ERROR_MESSAGE)) {
			throw new RuntimeException(errMsg);
		}
		return sum;
	}
}
