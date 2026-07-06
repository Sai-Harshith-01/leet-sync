class Solution {

    public int coinChange(int[] coins, int amount) {

        int dp[][] = new int[coins.length][amount+1];

        for(int row[] : dp)
            java.util.Arrays.fill(row,-1);

        int ans = solve(coins.length-1, amount, coins, dp);

        if(ans >= 1e9)
            return -1;

        return ans;
    }

    int solve(int i, int amount, int coins[], int dp[][]){

        if(i==0){

            if(amount%coins[0]==0)
                return amount/coins[0];

            return (int)1e9;
        }

        if(dp[i][amount]!=-1)
            return dp[i][amount];

        int notTake = solve(i-1, amount, coins, dp);

        int take = (int)1e9;

        if(coins[i]<=amount)
            take = 1 + solve(i, amount-coins[i], coins, dp);

        return dp[i][amount] = Math.min(take,notTake);
    }
}