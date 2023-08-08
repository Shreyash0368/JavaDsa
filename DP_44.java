import java.util.*;

public class DP_44 {
    private static int fibUtil(int n, int[] dp) {
        if (n == 0 || n == 1)
            return dp[n] = n;
        if (dp[n] != -1)
            return dp[n];

        return dp[n] = fibUtil(n - 1, dp) + fibUtil(n - 2, dp);
    }

    public static int fibonacci(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        fibUtil(n, dp);

        return dp[n];
    }

    public static int climbStairs(int n) { // u can either cross 1 stair or 2 ata time, give all possible way of
                                           // reaching n from 0
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        stairsDP(n, dp);

        return dp[n];
    }

    private static int stairsDP(int n, int[] dp) {
        if (n == 0 || n == 1)
            return dp[n] = 1;
        if (dp[n] != -1)
            return dp[n];

        return dp[n] = stairsDP(n - 1, dp) + stairsDP(n - 2, dp);
    }

    public static int frogJump(int n, int[] heights) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        jumpUtil(n - 1, heights, dp);
        return dp[n - 1];
    }

    private static int jumpUtil(int n, int[] heights, int[] dp) {
        if (n == 0)
            return dp[n] = 0;
        if (dp[n] != -1)
            return dp[n];

        int p1 = jumpUtil(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
        int p2 = Integer.MAX_VALUE;
        if (n > 1)
            p2 = jumpUtil(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);

        return dp[n] = Math.min(p1, p2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(8));
        System.out.println(climbStairs(10));
        int[] heights = { 10, 20, 30, 10 };
        System.out.println(frogJump(4, heights));

    }

}
