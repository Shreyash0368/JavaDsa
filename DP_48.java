import java.util.Arrays;

public class DP_48 {
    	public static boolean wildcardMatching(String pattern, String text) {
		int[][] dp = new int[pattern.length()][text.length()];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

        return matchingUtil(dp, pattern.length() - 1, text.length() - 1, pattern, text) != 0;
    }

    public static int matchingUtil(int[][] dp, int i1, int i2, String pattern, String text) {
        if (i1 < 0 && i2 >= 0) return 0;        
		if (i1 < 0 && i2 < 0) return 1;
		
        if (i2 < 0) {
            for (int t = 0; t <= i1; t++) {
                if (pattern.charAt(t) != '*') return 0;
            }
            return 1;
        } 

		if (dp[i1][i2] != -1) return dp[i1][i2];

        if (pattern.charAt(i1) == text.charAt(i2) || pattern.charAt(i1) == '?') return dp[i1][i2] = (matchingUtil(dp, i1 - 1, i2 - 1, pattern, text)) == 1 ? 1 : 0;
        if (pattern.charAt(i1) == '*') {
            return dp[i1][i2] = ((matchingUtil(dp, i1, i2 - 1, pattern, text)) == 1 || matchingUtil(dp, i1 - 1, i2, pattern, text) == 1) ? 1 : 0;
        }

        return dp[i1][i2] = 0;
    }

	public static boolean wildcardMatchingTab(String pattern, String text) {
		boolean[][] dp = new boolean[pattern.length() + 1][text.length() + 1];

		dp[0][0] = true; // base case 1 (when str1 exhausted)

		// base case 2 (when str 2 exhausted)
		for (int i1 = 1; i1 < dp.length; i1++) {
			boolean flag = true;
			for (int t = 0; t < i1; t++) {
				if (pattern.charAt(t) != '*')
					flag = false;
			}
			dp[i1][0] = flag;
		}

		for (int i1 = 1; i1 < dp.length; i1++) {
			for (int i2 = 1; i2 < dp[i1].length; i2++) {
				if (pattern.charAt(i1 - 1) == text.charAt(i2 - 1) || pattern.charAt(i1 - 1) == '?') {
					dp[i1][i2] = dp[i1 - 1][i2 - 1];
				} else if (pattern.charAt(i1 - 1) == '*') {
					dp[i1][i2] = dp[i1][i2 - 1] || dp[i1 - 1][i2];
				} else {
					dp[i1][i2] = false;
				}
			}
		}

		return dp[pattern.length()][text.length()];

	}


}
