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
            if (target == matrix[mid / cols][mid % cols]){
                return true;
            }else if (target > matrix[mid / cols][mid % cols]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
}

//binary search twice
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int start = 0, end = matrix.length - 1;
        int col = 0;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target){
                return true;
            }else if (matrix[mid][0] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        col = end >= 0 ? end : 0;
        start = 0;
        end = matrix[0].length-1;
        System.out.println(col);
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (matrix[col][mid] == target){
                return true;
            }else if (matrix[col][mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return false;
    }
}