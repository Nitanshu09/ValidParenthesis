import java.util.Stack;

public class ValidParentheses {
	static Boolean isValid(String s) {
		if (s == null || s.length() == 1 || s == "" || s.length() / 2 != (s.length() + 1) / 2) {
			return false;
		}
//		Stack<Integer> stack = new Stack<>();
//		for (int i = 0; i < s.length(); i++) {
//			if (s.charAt(i) == '(') {
//				stack.add(1);
//			} else if (s.charAt(i) == '{') {
//				stack.add(2);
//			} else if (s.charAt(i) == '[') {
//				stack.add(3);
//			} else if (s.charAt(i) == ')' && !stack.isEmpty()) {
//				int temp = stack.pop();
//				if (temp != 1) {																METHOD 1
//					return false;
//				}
//			} else if (s.charAt(i) == '}' && !stack.isEmpty()) {
//				int temp = stack.pop();
//				if (temp != 2) {
//					return false;
//				}
//			} else if (s.charAt(i) == ']' && !stack.isEmpty()) {
//				int temp = stack.pop();
//				if (temp != 3) {
//					return false;
//				}
//			} else {
//				return false;
//			}
//		}
//		if (!stack.isEmpty()) {
//			return false;
//		}
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.add(s.charAt(i));
			} else if (s.charAt(i) == ')' && !stack.isEmpty()) {
				char temp = stack.pop();
				if (temp == '[' || temp == '{') {
					return false;
				}
			} else if (s.charAt(i) == '}' && !stack.isEmpty()) { 								// METHOD 2
				char temp = stack.pop();
				if (temp == '(' || temp == '[') {
					return false;
				}
			} else if (s.charAt(i) == ']' && !stack.isEmpty()) {
				char temp = stack.pop();
				if (temp == '{' || temp == '(') {
					return false;
				}
			} else {
				return false;
			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return true;

	}

	public static void main(String[] args) {
		String s = "(){}}{";
		System.out.println(isValid(s));
	}

}
