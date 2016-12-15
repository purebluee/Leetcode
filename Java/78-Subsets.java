//Backtracking
//no duplicate subset allowed
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        res.add(new ArrayList<Integer>());
        List<Integer> tmp = new ArrayList<>();
        helper(nums, 0, res, tmp);
        return res;
    }
    
    private void helper(int[] nums, int start, List<List<Integer>> res, List<Integer> tmp){
        if (start >= nums.length){
            return;
        }
        
        for (int i = start; i < nums.length; i++){
            tmp.add(nums[i]);
            res.add(new ArrayList<Integer>(tmp));
            helper(nums, i + 1, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}