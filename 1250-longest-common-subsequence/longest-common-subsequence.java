class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // dp[i][j] stores the LCS of text1[i...n-1] and text2[j...m-1]
        int[][] dp = new int[n + 1][m + 1];

        // Iterate backwards from the end of both strings
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                // Fix: Use .charAt() for strings
                if (text1.charAt(i) == text2.charAt(j)) {
                    // Since we move backwards, the "next" state is i+1, j+1
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        // The answer for the full strings will be at dp[0][0]
        return dp[0][0];
    }
    
}