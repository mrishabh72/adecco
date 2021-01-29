package code;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

	private static String ERROR_MESSAGE = "negatives not allowed - ";

	public int add(String numbers) {
		int sum = 0;
		StringBuilder delimiter = new StringBuilder(",");
		String errMsg = ERROR_MESSAGE;

		if (numbers.startsWith("//[")) {
			delimiter = new StringBuilder("");
			numbers = numbers.substring(numbers.indexOf("["));

			List<StringBuilder> regBlock = new ArrayList<>();
			while (numbers.contains("[")) {
				String seperatorPattern = numbers.substring(numbers.indexOf("[") + 1, numbers.indexOf("]"));
				char[] seperatorPatternChars = seperatorPattern.toCharArray();
				for (int i = 0; i < seperatorPatternChars.length; i++) {
					if (i >= regBlock.size()) {
						regBlock.add(new StringBuilder());
					}
					regBlock.get(i).append(seperatorPatternChars[i]);

				}
				numbers = numbers.substring(numbers.indexOf("]") + 1);
			}
			for (StringBuilder reg : regBlock) {
				delimiter.append("[").append(reg).append("]");
			}
		} else if (numbers.startsWith("//")) {
			delimiter = new StringBuilder(numbers.substring(2, numbers.indexOf("\n")));
			numbers = numbers.substring(2 + delimiter.length());
		}
		Pattern pattern = Pattern.compile(delimiter.toString());
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
