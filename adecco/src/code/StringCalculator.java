package code;

public class StringCalculator {

	private static String ERROR_MESSAGE = "negatives not allowed - ";

	public int add(String numbers) {
		int sum = 0;
		String delimiter = ",";
		String errMsg = ERROR_MESSAGE;

		if (numbers.startsWith("//")) {
			delimiter = "" + numbers.charAt(2);
			numbers = numbers.substring(3);
		}

		String[] line = numbers.split("\n");
		for (String str : line) {
			String[] strs = str.split(delimiter);
			if (!strs[0].isEmpty()) {
				for (String strNum : strs) {
					int num = Integer.parseInt(strNum);
					if (num >= 0) {
						sum += num;
					} else {
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
