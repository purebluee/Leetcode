public class Solution {
    //DP with O(n) space:
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1)
            return nums[0];
        int max = 0;
        int len = nums.length;
        int[] maxM = new int[len];
        maxM[0] = nums[0];
        maxM[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++){
            maxM[i] = Math.max((maxM[i - 2] + nums[i]), maxM[i - 1]);
        }
        return maxM[len - 1];
    }
    //DP with constant space
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