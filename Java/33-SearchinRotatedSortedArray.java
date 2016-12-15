/*
The solution is very similar to binary search. Note that no matter how we rotated the array, 
there must be at least one part which is sorted. If the target is at the sorted part, we just 
search that part until we found; else we go the unsorted part. 
*/
public class Solution {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
         
        int lo = 0;
        int hi = A.length - 1;
         
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] == target) {
                return mid;
            }
             
            if (A[lo] <= A[mid]) {
                if (target >= A[lo] && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (A[mid] < target && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}