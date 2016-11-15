/*
Because the citation is sorted. We just need to use binary search.
Idea is we need to find if there exist a position in sorted array, that citation[i] >= citation.length - i.

for example:

2 5 6 9 10 12 15
7 6 5 4 3  2  1   <=== reverse index, tells how many elements(inclusive) to the right.

in order to find the h-index. we need to find if there exist a position that citation[i] >= reverse index.

So, like
check elements 2 and after >= 7? --> No
check elements 5 and after >= 6? --> No
check elements 6 and after >= 5? --> Yes! This is the max "h" value, we return this 5.

O(logn) runtime; O(1) space
*/

public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0){
            return 0;
        }
        int left = 0, right = citations.length - 1, len = citations.length;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (citations[mid] == len - mid){
                return len - mid;
            }else if (citations[mid] < len - mid){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return len - left;
    }
}