//Naive: sort first
public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
         
        Arrays.sort(A);
        int result = 0;
         
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= 0) {
                continue;
            }
             
            if (A[i] - result > 1) {
                return result + 1;
            } else {
                result = A[i];
            }
        }
        return A[A.length - 1] + 1;
    }
}

/*
A better Solution:
Since the problem requires for linear time complexity and constant space. 
We can think of using bucket sort idea. The idea is to check if the index i store the value i + 1, 
if not swap the the value A[i] to its desired index. After that, we iterate again the array and check 
the first position that i != A[i] + 1. 
*/
public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        int n = A.length;
        int i = 0;
        while (i < n) {
            if (A[i] != i + 1 && A[i] >= 1 && A[i] <= n && A[i] != A[A[i] - 1]) {
                swap(A, i, A[i] - 1);
            } else {
                i++;
            }
        }
         
        for (i = 0; i < n; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
         
        return A[n - 1] + 1;
    }
     
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

