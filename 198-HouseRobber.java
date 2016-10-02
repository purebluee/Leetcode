public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int i = 0;
        int e = 0;
        for (int k = 0; k < nums.length; k++){
            int tmp = i;
            i = nums[k] + e;
            e = Math.max(tmp, e);
        }
        return Math.max(i, e);
    }
}