package main;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("a b", 50));
		System.out.println(solution("The quick brown fox jumps over the lazy dog", 40));
		
	}
	
	
    public static String solution(String message, int K) {
    	if(isValid(message, K)) {
    		StringBuilder croppedMessage = new StringBuilder();
    		List<String> words = Arrays.asList(message.split(" "));
    		for (String word : words) {
    			int lengthAfterWord = croppedMessage.length() + word.length();
				if(lengthAfterWord <= K) {
					croppedMessage.append(word);
					croppedMessage.append(' ');
				} else {
					break;
				}
			}
    		return croppedMessage.toString().trim();
    	} else {
    		throw new IllegalArgumentException("Something is wrong with the input.");
    	}
    }
    
    public static boolean isValid(String message, int K) {
    	return  message.length() <= 500 
    			&& message.length() > 0
    			&& !message.contains("  ")
    			&& message.charAt(0) != ' '
    			&& message.charAt(message.length() - 1) != ' '
    			&& message.matches("[a-zA-Z\\s]+");
    }
}
