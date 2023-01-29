public class RainTrapping_14 {

    public static int rainWater(int [] array) {
        int waterTrapped = 0;
        int [] leftMax = new int[array.length];
        int [] rightMax = new int[array.length];
        leftMax[0] = array[0];
        rightMax[array.length- 1] = array[array.length - 1]; 
        
        // finding left max 
        for (int i = 1; i < array.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], array[i]);
            // System.out.print(leftMax[i] + " ");
        }        
        // right max
        for (int i = array.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(array[i], rightMax[i + 1]);
        }
        // calculating water collected
        for (int i = 0; i < array.length; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            waterTrapped += waterLevel - array[i];
        }

        return waterTrapped;
    }

    public static void main(String[] args) {

        int [] array = {4,2,0,6,3,2,5};
        int amount = rainWater(array);
        System.out.println(amount);
    }
}
