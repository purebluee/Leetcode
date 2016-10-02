//if both numbers are negative, product will be positive
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[] imax = new int[nums.length];
        int[] imin = new int[nums.length];
        imax[0] = nums[0];
        imin[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++){
            imax[i] = Math.max(Math.max(imax[i-1] * nums[i], imin[i-1] * nums[i]), nums[i]);
            imin[i] = Math.min(Math.min(imax[i-1] * nums[i], imin[i-1] * nums[i]), nums[i]);
            res = Math.max(res, imax[i]);
        }
        return res;
    }
}