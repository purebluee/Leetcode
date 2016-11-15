public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        
        int max = 0, m = matrix[0].length, n = matrix.length;
        
        // maxSquare(i, j) represents the length of the square 
        // whose lower-right corner is located at (i, j)
        // maxSquare(i, j) = min{ maxSquare(i-1, j-1), maxSquare(i-1, j), maxSquare(i, j-1) }
        int[][] maxSquare = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (matrix[i - 1][j - 1] == '1'){
                    maxSquare[i][j] = Math.min(maxSquare[i-1][j-1], Math.min(maxSquare[i-1][j], maxSquare[i][j-1])) + 1;//square is measured by the shorter edge
                    max = Math.max(max, maxSquare[i][j]);
                }
            }
        }
        return max * max;
    }
}