public class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            if (!hs.add(nums[i]))    
                hs.remove(nums[i]);
            else {
                res = nums[i];
            }
        }
        return hs.iterator().next();
    }
}