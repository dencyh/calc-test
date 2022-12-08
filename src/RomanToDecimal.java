import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class RomanToDecimal {
	public int getEquivalent(char symbol) {
		switch (symbol) {
			case 'I':
				return 1;
			case 'V':
				return 5;
			case 'X':
				return 10;
			case 'L':
				return 50;
			case 'C':
				return 100;
			case 'D':
				return 500;
			case 'M':
				return 1000;
			default:
				return 0;
		}
	}

	int romanToDecimal(String input) {
		int result = 0;

		for (int i = 0; i < input.length(); i++) {
			int current = getEquivalent(input.charAt(i));

			if (i + 1 >= input.length()) return result + current;

			int next = getEquivalent(input.charAt(i + 1));

			if (current >= next) {
				result = result + current; // XI
			} else {
				result = result + next - current; // IX
				i++;
			}

		}
		return result;
	}

	String decimalToRoman(int num) {
		String result = "";

		int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

		for (int i = 0; i < values.length; i++) {
			while (num >= values[i]) {
				num = num - values[i];
				result = result + letters[i];
			}
		}

		return result;
	}

}


