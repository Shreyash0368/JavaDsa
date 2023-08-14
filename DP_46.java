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

    public static int rodCut(int[] price, int n) {
        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return rodCutUtil(price, dp, n, n);

    }

    private static int rodCutUtil(int[] price, int[][] dp, int n, int len) {
        if (len == 0)
            return dp[n - 1][len] = 0;
        if (n == 1)
            return dp[n - 1][len] = price[0] * len;

        if (dp[n - 1][len] != -1)
            return dp[n - 1][len];

        int notCut = 0 + rodCutUtil(price, dp, n - 1, len);
        int cut = Integer.MIN_VALUE;
        if (n <= len)
            cut = price[n - 1] + rodCutUtil(price, dp, n, len - n);

        return dp[n - 1][len] = Math.max(cut, notCut);
    }

    public static int rodCutTabulation(int[] price, int len) {
        int[][] dp = new int[len + 1][len + 1];

        for (int n = 1; n < dp.length; n++) {
            for (int k = 1; k < dp[n].length; k++) {
                int notCut = 0 + dp[n - 1][k];
                int cut = Integer.MIN_VALUE;
                if (n <= k)
                    cut = price[n - 1] + dp[n][k - n];

                dp[n][k] = Math.max(notCut, cut);
            }
        }

        return dp[len][len];
    }

    public static int lcs(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return lcsUtil(s1, s2, s1.length() - 1, s2.length() - 1, dp);
    }

    private static int lcsUtil(String s1, String s2, int i1, int i2, int[][] dp) {
        if (i1 < 0 || i2 < 0)
            return 0;
        if (s1.charAt(i1) == s2.charAt(i2))
            return dp[i1][i2] = 1 + lcsUtil(s1, s2, i1 - 1, i2 - 1, dp);

        if (dp[i1][i2] != -1)
            return dp[i1][i2];

        int t1 = lcsUtil(s1, s2, i1 - 1, i2, dp);
        int t2 = lcsUtil(s1, s2, i1, i2 - 1, dp);

        return dp[i1][i2] = Math.max(t1, t2);
    }

    public static int lcsTabulation(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // 1 based indexing
        for (int i1 = 1; i1 < dp.length; i1++) {
            for (int i2 = 1; i2 < dp[i1].length; i2++) {
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
                    dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
                } else {
                    int t1 = dp[i1 - 1][i2];
                    int t2 = dp[i1][i2 - 1];

                    dp[i1][i2] = Math.max(t1, t2);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

}
