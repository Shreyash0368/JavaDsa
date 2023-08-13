import java.util.*;

public class DP_46 {
        public static int coinChange(int num[], int tar) {
        int[][] dp = new int[num.length][tar + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = coinChangeUtil(num, dp, num.length - 1, tar);
        if (ans >= (int) 1e9)
            ans = -1;
        return ans;
    }

    public static int coinChangeUtil(int[] num, int[][] dp, int n, int tar) {
        if (tar == 0)
            return dp[n][tar] = 0;
        if (n == 0) {
            if (tar % num[n] == 0) {
                return dp[n][tar] = tar / num[n];
            } else {
                return dp[n][tar] = (int) 1e9;
            }
        }

        if (dp[n][tar] != -1)
            return dp[n][tar];

        int notTake = 0 + coinChangeUtil(num, dp, n - 1, tar);
        int take = Integer.MAX_VALUE;
        if (num[n] <= tar)
            take = 1 + coinChangeUtil(num, dp, n, tar - num[n]);

        return dp[n][tar] = Math.min(notTake, take);
    }

    public static int coinChangeTabulation(int num[], int tar) {
        int[][] dp = new int[num.length][tar + 1];

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = (i % num[0] == 0) ? i / num[0] : (int) 1e9;
        }

        for (int n = 1; n < dp.length; n++) {
            for (int k = 1; k < dp[n].length; k++) {
                int notTake = 0 + dp[n - 1][k];
                int take = Integer.MAX_VALUE;
                if (num[n] <= k)
                    take = 1 + dp[n][k - num[n]];

                dp[n][k] = Math.min(notTake, take);
            }
        }

        return (dp[num.length - 1][tar] >= (int) 1e9 ? -1 : dp[num.length - 1][tar]);
    }

}
