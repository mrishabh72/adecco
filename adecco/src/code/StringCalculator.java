package code;

public class StringCalculator {

	public int add(String numbers) {
		int sum = 0;
		String delimiter =",";
		
		if(numbers.startsWith("//")) {
			delimiter= ""+numbers.charAt(2);
			numbers=numbers.substring(3);
		}
		
		String[] line = numbers.split("\n");
		for (String str : line) {
			String[] strs = str.split(delimiter);
			if (!strs[0].isEmpty()) {
				for (String strNum : strs) {
					sum += Integer.parseInt(strNum);
				}
			}
		}
		return sum;
	}

}
