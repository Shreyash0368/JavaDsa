import java.util.Arrays;

public class DP_47 {
    public static int longestCommonSubstring(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // 1 based indexing 
        int ans = 0;
        for (int i1 = 1; i1 < dp.length; i1++) {
            for (int i2 = 1; i2 < dp[i1].length; i2++) {
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
                    dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
                    ans = Math.max(ans, dp[i1][i2]);
                } 
            }
        }

        return ans;
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
                    int t2 = dp[i1][i2 -1];

                    dp[i1][i2] = Math.max(t1, t2);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
    
    public static int stringConversion(String s1, String s2) {
        // convert s1 to s2 by using only insert and delete
        int del, add;
        int lcs = lcsTabulation(s1, s2);
        del = s1.length() - lcs;
        add = s2.length() - lcs;

        return del + add;
    }

    public static int editDistance(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return distanceUtil(dp, s1.length() - 1, s2.length() - 1, s1, s2);
    }

    public static int distanceUtil(int[][] dp, int i1, int i2, String s1, String s2) {
        if (i2 < 0) {
            return i1 + 1;
        }
        if (i1 < 0) {
            return i2 + 1;
        }

        if (dp[i1][i2] != -1) return dp[i1][i2];

        
        if (s1.charAt(i1) == s2.charAt(i2)) return 0 + distanceUtil(dp, i1 - 1, i2 - 1, s1, s2);

        int insert = 1 + distanceUtil(dp, i1, i2 - 1, s1, s2);
        int delete = 1 + distanceUtil(dp, i1 - 1, i2, s1, s2);
        int replace = 1 + distanceUtil(dp, i1 - 1, i2 - 1, s1, s2);

        return dp[i1][i2] = Math.min(insert, Math.min(delete, replace));
    }
}
