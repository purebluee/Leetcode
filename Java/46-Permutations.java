public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        
        res.add(new ArrayList<Integer>());
        
        for (int i = 0; i < nums.length; i++){
            List<List<Integer>> currLevel = new ArrayList<>();
            for (int j = 0; j <= i; j++){
                for (List<Integer> l : res){
                    List<Integer> tmp = new ArrayList<>(l);
                    tmp.add(j, nums[i]);
                    currLevel.add(tmp);
                }
            }
            res = currLevel;
        }
        return res;
    }
}