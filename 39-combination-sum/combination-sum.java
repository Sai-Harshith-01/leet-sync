class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        backtrack(candidates, target, 0, new ArrayList<>());

        return ans;
    }

    void backtrack(int[] candidates,
                   int target,
                   int index,
                   List<Integer> current){

        
        if(target == 0){
            ans.add(new ArrayList<>(current));
            return;
        }

        
        if(target < 0)
            return;

        
        for(int i=index;i<candidates.length;i++){

        
            current.add(candidates[i]);

            
            backtrack(candidates,
                      target-candidates[i],
                      i,
                      current);

            
            current.remove(current.size()-1);

        }

    }
}