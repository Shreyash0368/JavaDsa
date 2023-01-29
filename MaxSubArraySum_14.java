public class MaxSubArraySum_14 {

    public static int prefixSum(int [] array) {
        int maxSum = Integer.MIN_VALUE, currSum = 0;
        int [] prefixArray = new int[array.length];
        prefixArray[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            prefixArray[i] = prefixArray[i - 1] + array[i];
        }

        currSum = prefixArray[0];

        for (int start = 1; start < prefixArray.length; start++) {
            for (int end = start; end < prefixArray.length; end++) {
                maxSum = Math.max(maxSum, currSum);
                currSum = prefixArray[end] - prefixArray[start - 1];
                // System.out.println(currSum+ ", "+ maxSum);
            }
        }

        return maxSum;
    }

    public static int kadaneAlgo(int [] array) {
        int maxSum = Integer.MIN_VALUE, currSum = 0;

        for (int i = 0; i < array.length; i++) {
            currSum += array[i];
            if (currSum < 0) {
                currSum = 0;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int [] array = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println("max sub array sum is: "+prefixSum(array));
        System.out.println("max sub array sum is: "+  kadaneAlgo(array));
        
    }    
}