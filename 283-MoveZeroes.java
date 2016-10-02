public class Solution {
    public void moveZeroes(int[] nums) {
        int counter = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] == 0){
                counter ++;
            }
            if (nums[i] != 0 && counter != 0){
                nums[i-counter] = nums[i];
                nums[i] = 0;
            }
        }
    }
}