import java.util.Arrays;

public class DP_45 {
        public static int zeroOneKnapsack(int[] val, int[] wt, int w) {
        int[][] dp = new int[val.length][w + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        knapsackUtil(val, wt, val.length - 1, w, dp);
        return dp[val.length - 1][w];
    }

    private static int knapsackUtil(int[] val, int[] wt, int n, int w, int[][] dp) {
        // base of when bag weight 0 or only single item
        if (w == 0)
            return dp[n][w] = 0;
        if (n == 0)
            return dp[n][w] = (wt[0] <= w) ? val[0] : 0;

        // checking if aready calculated
        if (dp[n][w] != -1)
            return dp[n][w];

        // exploring possibilities
        int notTake = 0 + knapsackUtil(val, wt, n - 1, w, dp);
        int take = Integer.MIN_VALUE;
        if (wt[n] <= w)
            take = val[n] + knapsackUtil(val, wt, n - 1, w - wt[n], dp);

        return dp[n][w] = Math.max(notTake, take);
    }

    public static int zeroOneKanpsackTabulation(int[] val, int[] weight, int wt) {
        int[] prev = new int[wt + 1];

        // filling first row
        for (int i = 0; i < prev.length; i++) {
            prev[i] = (weight[0] <= i) ? val[0] : 0;
        }

        for (int n = 1; n < val.length; n++) {
            int[] curr = new int[wt + 1];

            for (int w = 0; w <= wt; w++) {
                int notTake = 0 + prev[w];

                int take = Integer.MIN_VALUE;
                if (weight[n] <= w)
                    take = val[n] + prev[w - weight[n]];

                curr[w] = Math.max(notTake, take);
            }
            prev = curr;
        }

        return prev[wt];
    }

    public static int ninjaTraining(int[][] schedule) {
        int[][] dp = new int[schedule.length][4];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int days = schedule.length;
        ninjaTraingUtil(schedule, days - 1, 3, dp);
    
        return dp[schedule.length - 1][3];
    }

    private static int ninjaTraingUtil(int[][] schedule, int day, int prev, int[][] dp) {
        if (dp[day][prev] != -1)
            return dp[day][prev];
        
        if (day == 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < schedule[0].length; i++) {
                if (prev != i) {
                    max = Math.max(max, schedule[0][i]);                    
                }
            }
            return dp[day][prev] = max;
        }

       

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {           
            if (i != prev) {                               
                max = Math.max(max, schedule[day][i] + ninjaTraingUtil(schedule, day - 1, i, dp));
            }            
        }

        return dp[day][prev] = max;
    }

    public static int ninjaTrainingTabulation(int[][] schedule) {
        int[] prev = new int[3];        
        int max = Integer.MIN_VALUE;
        
        // filling first row 
        for (int i = 0; i < schedule[0].length; i++) {
            prev[i] = schedule[0][i];            
        }
        

        // next rows
        for (int i = 1; i < schedule.length; i++) {
            int[] curr = new int[3];
            for (int j = 0; j < 3; j++) {
                if (j == 0) 
                    curr[j] = schedule[i][j] + Math.max(prev[1], prev[2]);
                else if (j == 1)
                    curr[j] = schedule[i][j] + Math.max(prev[0], prev[2]);
                else if (j == 2)
                    curr[j] = schedule[i][j] + Math.max(prev[0], prev[1]);
            }
            prev = curr;
        }

        for (int i = 0; i < 3; i++) {
            max = Math.max(max, prev[i]);
        }


        return (max);
    }

    public static void main(String[] args) {
        int[] val = { 30, 40, 60 };
        int[] wt = { 3, 2, 4 };
        System.out.println(zeroOneKnapsack(val, wt, 5));
        System.out.println(zeroOneKanpsackTabulation(val, wt, 5));
        System.out.println("-------------");
        int[][] sch = {
                { 1,2,5 },
                { 3,1,1 },
                { 3,3,3 }
        };
        System.out.println(ninjaTraining(sch));
        System.out.println(ninjaTrainingTabulation(sch));
    }
}
