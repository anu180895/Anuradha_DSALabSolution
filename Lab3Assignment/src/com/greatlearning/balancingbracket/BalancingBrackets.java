package com.greatlearning.balancingbracket;

import java.util.Stack;

public class BalancingBrackets {

	static boolean hasBalancedBrackets(String str) {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == '(' || ch == '[' || ch == '{') {

				stack.push(ch);
				continue;
			}

			if (stack.isEmpty())
				return false;

			char check;
			switch (ch) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			default :
				return (stack.isEmpty());
			}
		}

		return (stack.isEmpty());
	}

	
	public static void main(String[] args) 
	{
		String inputString = "([[{}]])";

		if (hasBalancedBrackets(inputString))
			System.out.println("Given string is having balanced brackets ");
		else
			System.out.println("Given string is not having balanced brackets ");
	}
}