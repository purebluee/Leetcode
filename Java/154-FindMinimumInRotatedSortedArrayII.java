/*
The problem is similar to the search in rotated array II. 
The key is to handle when the duplicates exist. The only case where we need to handle specially is 
when nums[lo] == nums[mid] == nums[hi]. Because in this case, we have no idea which half to move. 
In this case, we move lo ++ .
*/

public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
         
        int lo = 0;
        int hi = nums.length - 1;
         
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[lo] == nums[mid] && nums[mid] == nums[hi]) {
                lo++;
            } else if (nums[lo] < nums[mid] && nums[mid] <= nums[hi]) {
                return nums[lo];
            } else if (nums[lo] <= nums[mid] && nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[lo] >= nums[mid] && nums[mid] <= nums[hi]) {
                hi = mid;
            }
        }
         
        if (nums[lo] <= nums[hi]) {
            return nums[lo];
        } else {
            return nums[hi];
        }
    }
}