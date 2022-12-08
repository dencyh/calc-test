class Calculator {
	int getResult(int a, String operator, int b) throws ScannerException {
		int result;
		switch (operator) {
			case "+":
				result = a + b;
				break;
			case "-":
				result = a - b;
				break;
			case "*":
				result = a * b;
				break;
			case "/":
				if (b == 0) {
					throw new ScannerException("Деление на 0 запрещено");
				}
				result = a / b;
				break;
			default:
				result = 0;
		}
		return result;
	}
}
