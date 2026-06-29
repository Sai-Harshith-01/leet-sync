class Solution {

    private void backtrack(int ind, int[] nums,
                           List<Integer> temp,
                           List<List<Integer>> ans) {

        // Base Case
        if (ind == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // Take
        temp.add(nums[ind]);
        backtrack(ind + 1, nums, temp, ans);

        // Not Take (Undo)
        temp.remove(temp.size() - 1);
        backtrack(ind + 1, nums, temp, ans);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), ans);

        return ans;
    }
}