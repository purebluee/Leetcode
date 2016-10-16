/*
In this problem, we have only three cases.

Case 1. The leftmost value is less than the rightmost value in the list: This means that the list is not rotated.
e.g> [1 2 3 4 5 6 7 ]

Case 2. The value in the middle of the list is greater than the leftmost and rightmost values in the list.
e.g> [ 4 5 6 7 0 1 2 3 ]

Case 3. The value in the middle of the list is less than the leftmost and rightmost values in the list.
e.g> [ 5 6 7 0 1 2 3 4 ]

As you see in the examples above, if we have case 1, we just return the leftmost value in the list. If we have case 2, we just move to the right side of the list. If we have case 3 we need to move to the left side of the list.

Following is the code that implements the concept described above.
*/


/*

    (1) loop is left < right, which means inside the loop, left always < right
    (2 ) since we use round up for mid, and left < right from (1), right would never be the same as mid
    (3) Therefore, we compare mid with right, since they will never be the same from (2)
    (4) if nums[mid] < nums[right], we will know the minimum should be in the left part, so we are moving right.
        We can always make right = mid while we don't have to worry the loop will not ends. Since from (2), we know right would never be the same as mid, making right = mid will assure the interval is shrinking.
    (5) if nums[mid] > nums[right], minimum should be in the right part, so we are moving left. Since nums[mid] > nums[right],mid can't be the minimum, we can safely move left to mid + 1, which also assure the interval is shrinking

*/
public class Solution {
    public int findMin(int[] nums) {
        if (nums == null)   return 0;
        int start = 0, end = nums.length - 1;
        while (start < end){
            int mid = start + (end - start) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]){
                return nums[mid];
            }else if (nums[mid] < nums[end]){
                end = mid;
            }
            //(nums[mid] > nums[start] && nums[mid] > nums[end])
            else{
                start = mid;
            } 
        }
        return nums[end];
    }
    
}