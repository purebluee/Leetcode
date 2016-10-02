public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        result[n-1] = 1;
        for(int i=n-2; i>=0; --i) {
            result[i] = result[i+1] * nums[i+1];
        }
        
        for(int i=0; i<n-1; ++i) {
            result[i] = result[i] * result[n-1];
            result[n-1] = result[n-1] * nums[i];
        }
        
        return result;
    }
}