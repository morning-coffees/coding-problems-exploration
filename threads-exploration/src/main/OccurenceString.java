package main;

public class OccurenceString {
	public static void main(String[] args) {
		// lines modified  = 2
		String S = "abc";
		int[] occurrences = new int[26];
        if(S.length() == 0 || S.length() > 100000) throw new IllegalArgumentException("Invalid string length");

		for (char ch : S.toCharArray()) {            
			if(ch - 'a' < 0 || (ch - 'a') > 25) throw new IllegalArgumentException("Invalid character");

			occurrences[ch - 'a']++;
		}

		char best_char = 'a';
		int best_res = 0;

		for (int i = 0; i < 26; i++) {
			if (occurrences[i] > best_res) {
				best_char = (char) ((int) 'a' + i);
				best_res = occurrences[i];
			}
		}
		System.out.println(Character.toString(best_char));
	}
}
