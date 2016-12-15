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

//sol with two pointers
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1){
            return;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length){
            if (nums[fast] != 0){
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }else{
                fast++;
            }
        }
        while (slow < nums.length){
            nums[slow] = 0;
            slow++;
        }
    }
}