package dumbell;

public class DumbellFromGPT {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int maxCapacity = 10;
    	int[] weights = {6,1,2,5,1, 1,2,3,4,5,6,7,8,9,0,10,11,12,13,14,15,16,17,17,1,2,1};

        int maxTotal = findMaxTotal(weights, maxCapacity);
        System.out.println(maxTotal);

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + " milliseconds");
    }

    public static int findMaxTotal(int[] weights, int maxCapacity) {
        return calculateMaxTotal(weights, 0, 0, maxCapacity);
    }

    public static int calculateMaxTotal(int[] weights, int currentIndex, int currentTotal, int maxCapacity) {
        if (currentIndex >= weights.length) {
            return currentTotal;
        }

        int includeCurrent = 0;
        if (currentTotal + weights[currentIndex] <= maxCapacity) {
            includeCurrent = calculateMaxTotal(weights, currentIndex + 1, currentTotal + weights[currentIndex], maxCapacity);
        }

        int excludeCurrent = calculateMaxTotal(weights, currentIndex + 1, currentTotal, maxCapacity);

        return Math.max(includeCurrent, excludeCurrent);
    }
}
