public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int slow = 1;
        int fast = 1;
        while (fast < nums.length){
            if (nums[fast] == nums[fast-1]){
                fast++;
            }else{
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }
        return slow;
    }
}