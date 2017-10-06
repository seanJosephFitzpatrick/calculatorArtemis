//TODO 1 Stack for Operators
//TODO 1 Queue for Output
//TODO 1 Array for tokens

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import org.apache.commons.lang3.math.NumberUtils;

public class InfixToPostfix {

	public static void main(String[] args) {
		String expression = "9 + 24 / ( 7 - 3 )";
		String[] tokens = expression.split("\\s");
		Queue<String> outputQueue = infixToPostfix(tokens);
		System.out.println(outputQueue);
	}

	public static Queue<String> infixToPostfix(String[] tokens) {
		Queue<String> outputQueue = new LinkedList<String>();
		Stack<String> operatorStack = new Stack<String>();

		for (String token : tokens){
			if (NumberUtils.isDigits(token)){
				outputQueue.add(token);
			} else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
				if (operatorStack.size() > 0) {
					while (checkPrecedence(operatorStack.peek()) > checkPrecedence(token)) {
						outputQueue.add(operatorStack.pop());
					}
				}
				operatorStack.push(token);
			} else if (token.equals("(")) {
				operatorStack.push(token);
			} else if (token.equals(")")) {
				while (!operatorStack.peek().equals("(")) {
					outputQueue.add(operatorStack.pop());
				}
				operatorStack.pop();
			}
		}
		while (operatorStack.size() > 0) {
			outputQueue.add(operatorStack.pop());
		}
		return outputQueue;
	}

	public static int checkPrecedence(String operator) {
		switch(operator) {
		case "+":
		case "-":
		case "(":
		case ")":
			return 0;
		case "*":
		case "/":
			return 1;
		default:
			throw new IllegalArgumentException("Operator unknown: " + operator);
		}
	}
}
