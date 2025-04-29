package day1;
import java.util.*;
public class evaexp {
	public static int evaluate(String expression) {
		Stack<Integer> numbers = new Stack<>();
		Stack<Character> operators = new Stack<>();
		int n = expression.length();
		for (int i = 0; i < n; i++) {
			char ch = expression.charAt(i);
				if (ch == ' ') continue;
				if (Character.isDigit(ch)) {
		        int num = 0;
		        while (i < n && Character.isDigit(expression.charAt(i))) {
		                    num = num * 10 + (expression.charAt(i) - '0');
		                    i++;
		                    }
		                i--; // Move back since for-loop increments i
		                numbers.push(num);
		            }
		            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
		                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
		                    int b = numbers.pop();
		                    int a = numbers.pop();
		                    numbers.push(applyOperation(a, b, operators.pop()));
		                }
		                operators.push(ch);
		            }
		        }
		        while (!operators.isEmpty()) {
		            int b = numbers.pop();
		            int a = numbers.pop();
		            numbers.push(applyOperation(a, b, operators.pop()));
		        }
		        return numbers.pop();
		    }
		    private static int precedence(char op) {
		        return (op == '+' || op == '-') ? 1 : 2; // * and / have higher precedence
		    }
		    private static int applyOperation(int a, int b, char op) {
		        return switch (op) {
		            case '+' -> a + b;
		            case '-' -> a - b;
		            case '*' -> a * b;
		            case '/' -> a / b; // Assuming valid input (no division by zero)
		            default -> 0;
		        };
		    }
		    public static void main(String[] args) {
		        String expression1 = "10 + 2 * 6";
		        String expression2 = "100 * 2 + 12 / 4";
		        System.out.println("Result: " + evaluate(expression1));
		        System.out.println("Result: " + evaluate(expression2));
	}
}