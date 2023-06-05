package dumbell;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	private static final Integer MAX_WEIGHT = 1000000000; 
	private static final Integer MAX_CAPACITY = 42; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> weights = Arrays.asList(156, 567, 287, 763, 89, 270, 612, 638, 405, 379);
		System.out.println(weightCapacity(weights, 916));
	}
	
    public static int weightCapacity(List<Integer> weights, int maxCapacity) {
    	System.out.println(weights.toString());
    	System.out.println(maxCapacity);
    	if(weights == null || weights.size() == 0) {
    		throw new IllegalArgumentException("Where's the dumbell?");
    	}
    	if(weights.size() > MAX_CAPACITY) {
    		throw new IllegalArgumentException("Too many dumbells!");
    	}
    	if(maxCapacity <= 0 || maxCapacity > MAX_WEIGHT) {
    		throw new IllegalArgumentException("Can't lift 'em!");
    	}
    	
    	HashMap<Integer, Integer> possibleMax = new HashMap<>();
    	for (int i = 0; i < weights.size(); i++) {
			for (int j = 0; j < weights.size(); j++) {
				if(weights.get(j) > MAX_WEIGHT) {
		    		throw new IllegalArgumentException("Can't lift 'em! Can i?");
				}
				Integer possibleMaxVal = possibleMax.getOrDefault(i, 0);
				if(j != i && possibleMaxVal + weights.get(j) <= maxCapacity) {
					possibleMax.put(i, possibleMaxVal + weights.get(j));
				}
				if(j != i && weights.get(i) + weights.get(j) <= maxCapacity && weights.get(i) + weights.get(j) > possibleMaxVal) {
					possibleMax.put(i, weights.get(i) + weights.get(j));
				}
			}
		}

    	System.out.println("===========");
    	Integer currentMax = 0;
    	for (Map.Entry<Integer, Integer> entry : possibleMax.entrySet()) {
			Integer val = entry.getValue();
			System.out.println(val);
			if(currentMax < val && val <= maxCapacity) {
				currentMax = val;
			}
		}
    	System.out.println("===========");
    	return currentMax;
    }
}
