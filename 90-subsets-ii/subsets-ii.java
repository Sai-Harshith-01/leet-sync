class Solution {

    private void backtrack(int ind, int[] nums,
                           List<Integer> temp,
                           List<List<Integer>> ans) {

        if (ind == nums.length) {

            List<Integer> copy = new ArrayList<>(temp);

          
            Collections.sort(copy);

            
            if (!ans.contains(copy)) {
                ans.add(copy);
            }

            return;
        }

        // Take
        temp.add(nums[ind]);
        backtrack(ind + 1, nums, temp, ans);

        // Not Take
        temp.remove(temp.size() - 1);
        backtrack(ind + 1, nums, temp, ans);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums); 

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), ans);

        return ans;
    }
}