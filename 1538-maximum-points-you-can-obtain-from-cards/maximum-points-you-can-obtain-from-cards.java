class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int ls = 0, rs = 0;

        for (int i = 0; i < k; i++) {
            ls += cardPoints[i];
        }

        int ms = ls;

        int ind = cardPoints.length - 1;

        for (int i = k - 1; i >= 0; i--) {

            rs += cardPoints[ind--];
            ls -= cardPoints[i];

            ms = Math.max(ms, ls + rs);
        }

        return ms;
    }
}