public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)   return 0;
        int start = 0, end = nums.length - 1;
        while (start < end){
            int mid1 = start + (end - start) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid2] > nums[mid1])
                start = mid2;
            else if (nums[mid2] < nums[mid1])
                end = mid1;
        }
        return nums[left] > nums[right] ? left : right;
    }
}