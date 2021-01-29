package code;

public class StringCalculator {

	public int add(String numbers) {
		String[] strs = numbers.split(",");
		if (strs[0].isEmpty()) {
			return 0;
		} else if (strs.length == 1) {
			return Integer.parseInt(strs[0]);
		} else if (strs.length == 2) {
			int no1 = Integer.parseInt(strs[0]);
			int no2 = Integer.parseInt(strs[1]);
			return no1 + no2;
		}
		return 0;
	}

}
