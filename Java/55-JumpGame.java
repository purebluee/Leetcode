public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }
        if (nums.length == 1){
            return true;
        }
        int maxStep = nums[0];
        for (int i = 0; i < nums.length; i++){
            if (maxStep < i){
                return false;
            }else if (maxStep >= nums.length - 1){
                return true;
            }else{
                maxStep = Math.max(i + nums[i], maxStep);
            }
        }
        return maxStep >= nums.length - 1;
    }
}

//Not good: backtracking
public class Solution {
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }
}