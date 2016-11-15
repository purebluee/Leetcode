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
    //Second solution
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int p = 1, len = nums.length;
        for (int i = 1; i < len; i++){
            if (nums[i] != nums[i-1]){
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }
}