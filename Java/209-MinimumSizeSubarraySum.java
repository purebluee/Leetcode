/*
Since the array elements are all positive numbers, we could use a sliding window approach. 
W first move the front pointer until the sum of the subarray is greater or equal to the target value s, 
then we calculate the size of the window. Then we try to move the rear pointer and recalculate the window size, 
until the sum of the window is less than the target s. 
*/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length, sum = 0, minLen = Integer.MAX_VALUE, low = 0, high = 0;
        while (high < len){
            if (sum < s){
                sum += nums[high];
                high++;
            }
            while (low <= high && sum >= s){
                minLen = Math.min(minLen, high - low);
                sum -= nums[low];
                low++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}