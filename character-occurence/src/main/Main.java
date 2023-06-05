package main;

public class Main {

	public static void main(String[] args) {
		String s = "";
		System.out.println(solution(s));
	}
	
	public static String solution(String S) {
        int[] occurrences = new int[26];
        if(S.length() == 0 ||  S.length() > 100000 ) throw new IllegalArgumentException("Invalid Input size");
        for (char ch : S.toCharArray()) {
        	if(ch - 'a' < 0 || ch - 'a' > 25) throw new IllegalArgumentException("Invalid Input Character");
        	occurrences[ch - 'a']++;
        }

        char best_char = 'a';
        int  best_res  = 0;

        for (int i = 0; i < 26; i++) {//
            if (occurrences[i] > best_res || ( occurrences[i] == best_res && (char)((int)'a' + i) < best_char)) { //
                best_char = (char)((int)'a' + i);
                best_res  = occurrences[i];
            }
        }

        return Character.toString(best_char);
    }
}
