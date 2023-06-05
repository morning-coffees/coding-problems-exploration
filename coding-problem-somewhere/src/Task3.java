import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Task3 {

	public static void main(String[] args) {
		System.out.println("Start...");
		System.out.println(solution(1154));
	}
	
    public static int solution(int N) {
    	N += 1;
    	
    	if(N < 10) {
    		return N;
    	}
    	
    	Integer num = N;
    	List<Integer> digits = numberAsList(N);
    	
    	for (int i = 0; i < digits.size() - 1; i++) {
    		System.out.println(digits.toString());
			if(Objects.equals(digits.get(i), digits.get(i+1))) {
				int increasedValueRight = digits.get(i+1) + 1;
				if(increasedValueRight < 10) {
					digits.set(i+1, increasedValueRight);
					setAllRightToZero(digits, i+2);
				} else {
					// int increasedValueLeft = digits.get(i) + 1;
					digits.set(i, digits.get(i) + 1);
					setAllRightToZero(digits, i+1);
					i = -1;
				}

			} else if (digits.get(i+1) == 10) {
				digits.set(i, digits.get(i) + 1);
				setAllRightToZero(digits, i+1);
			}
		}
    	System.out.println(digits.toString());
    	
		return toInteger(digits);
    }
    
    public static void setAllRightToZero(List<Integer> digits, int startIndex) {
    	for (int i = startIndex; i < digits.size(); i++) {
        	System.out.println("Setting to 0 from " + startIndex);
			digits.set(i, 0);
		} 
    }
    
    public static List<Integer> numberAsList(int num) {
    	List<Integer> array = new ArrayList<Integer>();
    	do{
    	    array.add(num % 10);
    	    num /= 10;
    	} while  (num > 0);
    	Collections.reverse(array);
		return array;
    }
    
    public static int toInteger(List<Integer> nums) {
    	int pos = 1;
    	int finalNumber = 0;
    	for (int i = nums.size() - 1; i >= 0; i--) {
			finalNumber += nums.get(i) * pos;
			pos *= 10;
		}
		return finalNumber;
    }
}
