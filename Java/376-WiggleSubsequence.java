public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int d = 1, f = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > nums[i-1])
                d = f + 1;
            else if(nums[i] < nums[i-1])
                f = d + 1;
        }
        return Math.min(nums.length, Math.max(d,f));
    }
}