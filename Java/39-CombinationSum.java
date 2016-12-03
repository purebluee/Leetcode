/*
Combination Sum I

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(candidates, target, 0, curr, res);
        return res;
    }
    
    public void helper(int[] cand, int target, int start, List<Integer> curr, List<List<Integer>> res){
        if (target > 0){
            for (int i = start; i < cand.length; i++){
                curr.add(cand[i]);
                helper(cand, target - cand[i], i, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
        if (target == 0){
            res.add(new ArrayList<>(curr));
        }
    }
}

Combination Sum II

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, res, curr);
        return res;
    }
    
    private void helper(int[] cand, int target, int start, List<List<Integer>> res, List<Integer> curr){
        if (target > 0){
            for (int i = start; i < cand.length; i++){
                if (i > start && cand[i] == cand[i-1]){
                    continue;
                }
                curr.add(cand[i]);
                helper(cand, target - cand[i], i + 1, res, curr);
                curr.remove(curr.size()-1);
            }
        }
        else if (target == 0){
            res.add(new ArrayList<Integer>(curr));
        }
    }
}

Combination Sum III

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(k, n, res, curr, 1);
        return res;
    }
    
    private void helper(int k, int target, List<List<Integer>> res, List<Integer> curr, int start){
        if (target == 0 && curr.size() == k){
            res.add(new ArrayList<>(curr));
        }
        if (curr.size() < k){
            for (int i = start; i <= 9; i++){
                curr.add(i);
                helper(k, target - i, res, curr, i+1);//to avoid repeated numbers
                curr.remove(curr.size() - 1);
            }
        }
    }
}
*/

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