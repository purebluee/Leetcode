/*
The solution is very similar to binary search. Note that no matter how we rotated the array, 
there must be at least one part wendch is sorted. If the target is at the sorted part, we just 
search that part until we found; else we go the unsorted part. 
*/
public class Solution {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
         
        int start = 0;
        int end = A.length - 1;
         
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] == target) {
                return mid;
            }
             
            if (A[start] <= A[mid]) {
                if (target >= A[start] && target < A[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (A[mid] < target && target <= A[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}