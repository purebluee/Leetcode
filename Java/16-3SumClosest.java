public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length <= 3){
            int sum = 0;
            for (int i : nums){
                sum += i;
            } 
            return sum;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int res = nums[1] + nums[2] + nums[3];
        for (int i = 0; i < n - 2; i++){
            int j = i + 1, k = n - 1;
            while (j < k){
                sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < Math.abs(target - res)){
                //if (Math.abs(sum - target) < min){
                    res = sum;
                    //min = sum;
                    if (sum == target)
                        return target;
                }
                if (sum > target)
                    k--;
                else
                    j++;
            }
        }
        return res;
    }
}