import java.util.*;

public class ActivitySelect_29 {
    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };
        // here the jobs are sequenced by end time already (if in question they are not
        // than we need to sort them by end time)

        // sorting by end time (in case not given)
        int[][] activities = new int[start.length][3];

        for (int i = 0; i < start.length; i++) {
            // storing original index in 1st col
            activities[i][0] = i;

            // storing st time
            activities[i][1] = start[i];

            // storing the end time
            activities[i][2] = end[i];
        }
                                                        // here o -> o[2] means sort based on the 3rd column   
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        // this is known as lambda function (shor form of a large function)

        int maxAct = 1; // we can have at least 1 activity always
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(activities[0][0]); // add index of first activity 
        int prevEnd = activities[0][2]; // end time of prev activity (here the 1st one)

        // parsng job list for possible activities
        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= prevEnd) { // if start time of current is greater than or equal to end time of prev activity than add it to the list
                ans.add(activities[i][0]);
                maxAct++;
                prevEnd = activities[i][2];                
            }
        }
        
        System.out.println("max activities: " + maxAct);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A"+ ans.get(i) +" ");
        }
        System.out.println();
    }
    
}


