package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sol1 {
    // Helper method to check if a character is within lowercase alphabet
    private static boolean isLowerCaseLetter(char c) {
        return c >= 'a' && c <= 'z';
    }
    
	public int[] start2(String[] S) {
		// Validation
		int lengthS = S.length;
		if(lengthS > 30000 || lengthS == 0) {
			throw new IllegalArgumentException("S lenght valid value: 1..30000");
		}
		
		int lengthM = S[0].length();

    	if(lengthS * lengthM > 30000) {
			throw new IllegalArgumentException("S*M lenght valid value: <=30000");
    	}
    	
        for (int a = 1; a < S.length; a++) {
        	if(lengthM != S[a].length()) {
    			throw new IllegalArgumentException("M lengths should be the same");
        	}
        }

		// --------- Implementaion
		
		Map<String, Integer> charIndexMap = new HashMap<>();

        for (int a = 0; a < S.length; a++) {
            String el = S[a];
            for (int elChars = 0; elChars < el.length(); elChars++) {
                char elChar = el.charAt(elChars);
                if (!isLowerCaseLetter(elChar)) {
                    throw new IllegalArgumentException("Invalid character found: " + elChar + ", Should only be lowercase alphabet");
                }
                String indexKey = elChars + "-" + elChar;
                if (charIndexMap.containsKey(indexKey)) {
                    int b = charIndexMap.get(indexKey);
                    return new int[]{b, a, elChars};
                } else {
                    charIndexMap.put(indexKey, a);
                }
            }
        }

        return new int[0];
	}
	
	public int[] start(String[] S) {
		List<Integer> result = new ArrayList<>();
		
		rootLoop:
		for(int a = 0; a < S.length; a++) {
			String elA = S[a];
			for(int elAChars = 0; elAChars < elA.length(); elAChars++) {
				char elAChar = elA.charAt(elAChars);
				for(int b = 0; b < S.length; b++) {
					if(a == b) {
						continue;
					}
					String elB = S[b];
					for(int elBChars = 0; elBChars < elB.length(); elBChars++) {
						if( elAChars == elBChars && elB.charAt(elBChars) == elAChar) {
							result.add(0, a);
							result.add(1, b);
							result.add(2, elAChars);
							break rootLoop;
						}
					}
				}
			}
		}
		
		return result.stream()
                .mapToInt(i -> i != null ? i : 0)
                .toArray();
	}

}
