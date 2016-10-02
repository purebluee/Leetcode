public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0 || nums == null)
            return false;
        int maxIndex = nums.length - 1;
        int maxJump = nums[0];
        for (int i = 0; i <= maxJump; i++){
            maxJump = Math.max (maxJump, i + nums[i]);
            if (maxJump >= maxIndex)
                return true;
        }
        return false;
    }
}