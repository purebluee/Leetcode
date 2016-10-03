public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int len = nums.length, insertPoint = 0;
        for (int num : nums){
            if (num != 0){
                nums[insertPoint] = num;
                insertPoint++;
            }
        }
        for (int i = insertPoint; i < len; i++){
            nums[i] = 0;
        }
    }
}