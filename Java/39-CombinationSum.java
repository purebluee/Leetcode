//backtracking
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(res, curr, target, candidates, 0);
        return res;
    }
    
    void helper(List<List<Integer>> res, List<Integer> curr, int target, int[] candidates, int start){
        if (target > 0){
            for (int i = start; i < candidates.length; i++){
                curr.add(candidates[i]);
                helper(res, curr, target-candidates[i], candidates, i);
                curr.remove(curr.size()-1);
            }
        }
        if (target == 0)
            res.add(new ArrayList<Integer>(curr));
    }
}