class Solution {

    int[][] dp;

    public int uniquePaths(int m, int n) {

        dp = new int[m][n];

        
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 0, m, n);
    }

    int solve(int row, int col, int m, int n) {

      
        if (row == m - 1 && col == n - 1)
            return 1;

       
        if (row >= m || col >= n)
            return 0;

     
        if (dp[row][col] != -1)
            return dp[row][col];

       
        dp[row][col] = solve(row + 1, col, m, n)
                     + solve(row, col + 1, m, n);

        return dp[row][col];
    }
}