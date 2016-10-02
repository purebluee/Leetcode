public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length ==0) 
        	return res;
        res.add(new ArrayList<Integer>());
        for (int i = 0; i< nums.length; ++i){
            List<List<Integer>> new_ans = new ArrayList<List<Integer>>(); 
            for (int j = 0; j<=i; ++j){            
               for (List<Integer> l : res){
                   List<Integer> new_l = new ArrayList<Integer>(l);
                   new_l.add(j,nums[i]);
                   new_ans.add(new_l);
               }
            }
            res = new_ans;
        }
        return res;
    }
}