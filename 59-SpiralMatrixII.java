public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) return matrix;
        int top = 0, left = 0, right = n - 1, bottom = n - 1;
        int curr = 1;
        
        while (left <= right){
            for (int i = left; i <= right; i++){
                matrix[top][i] = curr;
                curr++;
            }
            top++;
            for (int i = top; i <= bottom; i++){
                matrix[i][right] = curr;//Attention!!
                curr++;
            }
            right--;
            for (int i = right; i >= left; i--){
                matrix[bottom][i] = curr;
                curr++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--){
                matrix[i][left] = curr;//Attention!!
                curr++;
            }
            left++;
        }
        return matrix;
    }
}