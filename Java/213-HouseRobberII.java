
//without helper
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        if (len == 1){
            return nums[0];
        }
        //rob the first one:
        int[] inclusive = new int[len];
        inclusive[0] = nums[0];
        inclusive[1] = nums[0];
        for (int i = 2; i < len-1; i++){
            inclusive[i] = Math.max(inclusive[i-2] + nums[i], inclusive[i-1]);
        }
        //not rob the first one:
        int[] exclusive = new int[len];
        exclusive[0] = 0;
        exclusive[1] = nums[1];
        for (int i = 2; i < len; i++){
            exclusive[i] = Math.max(exclusive[i-2] + nums[i], exclusive[i-1]);
        }
        return Math.max(inclusive[len-2], exclusive[len-1]);
    }
}

//recursive
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)   return nums[0];
        return Math.max(helper(nums, 0, nums.length-2), helper(nums, 1, nums.length-1));
    }
    
    int helper(int[] nums, int start, int end){
        int include = 0, exclude = 0;
        for (int p = start; p <= end; p++){
            int i = include, e = exclude;
            include = e + nums[p];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }
}