package code;

public class StringCalculator {

	public int add(String numbers) {
		String[] strs = numbers.split(",");
		if (strs[0].isEmpty()) {
			return 0;
		} else if (strs.length == 1) {
			return Integer.parseInt(strs[0]);
		} else if (strs.length > 1) {
			int sum = 0;
			for(String str:strs) {
				sum+=Integer.parseInt(str);
			}
			return sum;
		}
		return 0;
	}

}
