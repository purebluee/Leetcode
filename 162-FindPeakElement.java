/*
Treat as a sorted 1D array
*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)   return false;
        int rows = matrix.length, cols = matrix[0].length;
        int start = 0, end = rows * cols - 1;
        
        while ( start <= end){
            int mid = start + (end - start) / 2;
            if (target == matrix[mid/cols][mid%cols]){
                return true;
            }else if (target > matrix[mid/cols][mid%cols]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
}