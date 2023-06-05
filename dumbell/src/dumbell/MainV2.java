package dumbell;

public class MainV2 {

	private static final Integer MAX_CAPACITY = 10; 
	private static Integer currentMax = 0;
	private static int[] weights = {6,1,2,5,1, 1,2,3,4,5,6,7,8,9,0,10,11,12,13,14,15,16,17,17,1,2,1,16,17,17,1,2,1};
	
	public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        
		weightCapacity();
		System.out.println(currentMax);

		
		long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + " milliseconds");

	}
	
	public static void weightCapacity() {
		start(0, 0);
    }
	
	public static void start(int currentIndex, int currentTotal) {
		if(currentIndex < weights.length) {
			int newTotal = currentTotal + weights[currentIndex];

			if(newTotal > currentMax && newTotal <= MAX_CAPACITY) {
				currentMax = newTotal;
			}

			//include
			if(newTotal > MAX_CAPACITY) {
				start(currentIndex + 1, newTotal);				
			}
			
			//exclude
			start(currentIndex + 1, currentTotal);
		}	
	}
}
