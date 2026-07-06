class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        backtrack(candidates,
                  target,
                  0,
                  new ArrayList<>());

        return ans;
    }

    void backtrack(int[] nums,
                   int target,
                   int index,
                   List<Integer> current){

    
        if(target==0){

            ans.add(new ArrayList<>(current));

            return;
        }

       
        for(int i=index;i<nums.length;i++){

            
            if(i>index &&
               nums[i]==nums[i-1])

                continue;

            if(nums[i]>target)
                break;

            
            current.add(nums[i]);

          
            backtrack(nums,
                      target-nums[i],
                      i+1,
                      current);

           
            current.remove(current.size()-1);

        }

    }
}