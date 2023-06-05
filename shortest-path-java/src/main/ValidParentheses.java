package main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		Map<Character, Character> parenthesesPair = new HashMap<>();
		parenthesesPair.put('(', ')');
		parenthesesPair.put('[', ']');
		parenthesesPair.put('{', '}');
		
		String input = "([)]";
		
		Stack<Character> pStack = new Stack<>();
		
		for(int i = 0; i < input.length(); i++) {
			boolean isOpenClosePaired = pStack.size() > 0 && parenthesesPair.getOrDefault(pStack.lastElement(), null) == input.charAt(i);
			if( isOpenClosePaired ) {
				pStack.pop();
			} else {
				pStack.add(input.charAt(i));
			}
		}
		
		if(!pStack.isEmpty()) {
			System.out.println("Not valid");
		} else {
			System.out.println("Valid");;
		}
//		if((input.length() > 1 && !pStack.isEmpty() || input.length() == 0)) {
//			System.out.println("Not valid");
//		} else {
//			System.out.println("Valid");;
//		}
		System.out.println(pStack.toString());
	}

}
