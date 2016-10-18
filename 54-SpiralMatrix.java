public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null)
            return res;
            
        int top = 0, left = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;

        while (left <= right && top <= bottom){
            for (int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            top++;
            if (top > bottom){
                break;
            }
            for (int i = top; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            right--;
            if (left > right){
                break;
            }
            for (int i = right; i >= left; i--){
                res.add(matrix[bottom][i]);
            }
            bottom--;

            for (int i = bottom; i >= top; i--){
                res.add(matrix[i][left]);
            }
        
            left ++;
        }
        return res;
    }
}