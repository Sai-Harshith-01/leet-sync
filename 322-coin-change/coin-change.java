class Solution {

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        int INF = (int)1e9;

        int prev[] = new int[amount+1];

        for(int j=0;j<=amount;j++){

            if(j%coins[0]==0)
                prev[j]=j/coins[0];
            else
                prev[j]=INF;
        }

        for(int i=1;i<n;i++){

            int curr[] = new int[amount+1];

            for(int j=0;j<=amount;j++){

                int notTake = prev[j];

                int take = INF;

                if(coins[i]<=j)
                    take = 1 + curr[j-coins[i]];

                curr[j]=Math.min(take,notTake);
            }

            prev=curr;
        }

        if(prev[amount]>=INF)
            return -1;

        return prev[amount];
    }
}