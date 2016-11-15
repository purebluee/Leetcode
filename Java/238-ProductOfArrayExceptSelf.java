public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        
        result[len - 1] = 1;
        for(int i = len - 2; i >= 0; i--) {
            result[i] = result[i + 1] * nums[i + 1];
        }
        
        for(int i=0; i<len-1; i++) {
            result[i] = result[i] * result[len - 1];
            result[len - 1] = result[len - 1] * nums[i];
        }
        
        return result;
    }
}