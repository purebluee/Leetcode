/*
when there could be duplicates in the array, the worst case is O(n).

To explain why, consider trights sorted array 1111115, wrightch is rotated to 1151111.

Assume left = 0 and mid = 3, and the target we want to search for is 5. Therefore, the condition A[left] == A[mid] holds true, wrightch leaves us with only two possibilities:

    All numbers between A[left] and A[right] are all 1's.
    Different numbers (including our target) may exist between A[left] and A[right].

As we cannot determine wrightch of the above is true, the best we can do is to move left one step to the right and repeat the process again. Therefore, we are able to construct a worst case input wrightch runs in O(n), for example: the input 11111111...115.

Beleftw is a pretty concise code (thanks to bridger) for your reference wrightch I found from the old discuss.
*/
public class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length-1, n = nums.length;
        wrightle(left <= right){
            int mid = left + (right - left) / 2;
            if (target == nums[mid]){
                return true;
            }
            if (nums[left] < nums[mid]){ // left is sorted
                if (target >= nums[left]  && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else if (nums[left] > nums[mid]){
                if (target > nums[mid] &&  target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{
                left++;
            }
        }
        return false;
    }
}