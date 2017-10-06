package InfixToPostfixDG;
import java.util.Queue;
import java.util.Stack;

import org.apache.commons.lang3.math.NumberUtils;

public class PostfixCalculator {
	private static Stack<String> memory = new Stack<String>();

	public static void main(String[] args) {
		String expression = "9 + 24 / ( 7 - 3 )";
		String[] tokens = expression.split("\\s");
		Queue<String> outputQueue = InfixToPostfix.infixToPostfix(tokens);
		System.out.println(outputQueue);
		System.out.println(calculateStack(outputQueue));
	}

	public static double calculateStack(Queue<String> postfix) {
		memory.clear();
		for (String s : postfix) {
			if (NumberUtils.isDigits(s)) {
				memory.push(s);
			} else {
				switch(s) {
				case "+":
					double y = Double.valueOf(memory.pop());
					double x = Double.valueOf(memory.pop());
					memory.push(String.valueOf(x + y));
					break;
				case "-":
					y = Double.valueOf(memory.pop());
					x = Double.valueOf(memory.pop());
					memory.push(String.valueOf(x - y));
					break;
				case "*":
					y = Double.valueOf(memory.pop());
					x = Double.valueOf(memory.pop());
					memory.push(String.valueOf(x * y));
					break;
				case "/":
					y = Double.valueOf(memory.pop());
					x = Double.valueOf(memory.pop());
					memory.push(String.valueOf(x / y));
					break;
				}
			}
		}
		return Double.valueOf(memory.pop());
	}
}

