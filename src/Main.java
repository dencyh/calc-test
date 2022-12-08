import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws ScannerException {

		Scanner in = new Scanner(System.in);
		System.out.println("Введите выражение:");
		String input = in.nextLine();

		String result = calc(input);
		System.out.println(result);
	}

	public static String calc(String input) throws ScannerException {

		boolean isRoman = true;
		Set<String> operators = Set.of(
				"+", "-", "/", "*"
		);
		RomanToDecimal converter = new RomanToDecimal();
		Calculator calculator = new Calculator();

		String[] expression = input.trim().split(" ");

		if (expression.length < 3 || expression.length > 3) {
			throw new ScannerException("Строка не является математической операцией");
		}

		String operator = expression[1];
		if (!operators.contains(operator)) {
			throw new ScannerException("Строка не является математической операцией");
		}

		int a = converter.romanToDecimal(expression[0]);
		int b = converter.romanToDecimal(expression[2]);
		if ((a == 0 ^ b == 0)) {
			throw new ScannerException("Нельзя использовать одновременно разные системы счисления");
		}

		if (operator.equals("-") && a <= b) {
			throw new ScannerException("В римской системе нет отрицательных чисел и нуля");
		}

		if (a == 0 && b == 0) {
			try {
				isRoman = false;
				a = Integer.parseInt(expression[0]);
				b = Integer.parseInt(expression[2]);
			} catch (NumberFormatException e) {
				throw new ScannerException("Строка не является математической операцией");
			}
		}

		if (a > 11 || b > 11) {
			throw new ScannerException("Можно использовать только числа от 1 до 10 включительно");
		}

		int result = calculator.getResult(a, operator, b);

		if (isRoman) {
			return String.valueOf(converter.decimalToRoman(result));
		}
		return String.valueOf(result);


	}
}
