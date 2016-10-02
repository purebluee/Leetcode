//XOR
public class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++){
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }
}

public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length;
        while (start < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] > mid){
                end = mid;
            }else
                start = mid+1;
        }
        return start;
    }
}