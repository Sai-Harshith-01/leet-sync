class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> ans = new ArrayList<>();
        boolean take = true;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {

            if (i % 2 == 0) {
               
                for (int j = 0; j < cols; j++) {
                    if (take) {
                        ans.add(grid[i][j]);
                    }
                    take = !take;
                }
            } else {
              
                for (int j = cols - 1; j >= 0; j--) {
                    if (take) {
                        ans.add(grid[i][j]);
                    }
                    take = !take;
                }
            }
        }

        return ans;
    }
}