/*
Understand the problem:
The problem itself is straight-forward. We can easily think of iterating all elements of the matrix, and for each element, we find the largest possible rectangles containing all ones. 
So we can expect that the time complexity would be O(m * n * m * n).

A better Solution:
We could maintain a dp matrix[m][n], where each row means the the height of 1's. Then scan each element of the matrix and update the height.

At last, for each row, we know the histogram of each row, of which the value is the height of each element of that row. Then we can use the method Max rectangle of histogram to find out the largest rectangle.  

dp[i][j] - the maximal height for row i and column j.

The initial value of the DP matrix is the first row
for (int i = 0; i < n; i++) {
    dp[0][i] = matrix[0][i];
}

The transit function is:
if (matrix[i][j]) == 0, dp[i][j] = 0;
if (matrix[i][j]) == 1, dp[i][j] = dp[i - 1][j] + 1;

The final state is to check the Math.max( max,  maxRectangleHistogram(matrix[i]) )

For example,
The input matrix is:
0    0    1    0
0    1    1    0
0    1    1    0
0    0    0    1

So the DP matrix is
0    0    1     0             1
0    1    2     0             2
0    2    3     0             4
0    0    0     1             1

So the output is 4.


*/

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
         
        int m = matrix.length;
        int n = matrix[0].length;
         
        int[][] dp = new int[m][n];
         
        // initialization
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] - '0';
        }
         
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != '0') {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }
         
        // find the max rectanlge histogram
        int max = 0;
        for (int i = 0; i < m; i++) {
            int localSum = maxRectangleHistogram(dp[i]);
            max = Math.max(max, localSum);
        }
         
        return max;
    }
     
    private int maxRectangleHistogram(int[] height) {
        if (height.length == 1) {
            return height[0];
        }
         
        Stack<Integer> stack = new Stack<Integer>();
        int[] height2 = new int[height.length + 1];
        height2 = Arrays.copyOf(height, height.length + 1);
         
        int i = 0;
        int maxArea = 0;
        while (i < height2.length) {
            if (stack.isEmpty() || height2[i] > height2[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int index = stack.pop();
                int localMax = 0;
                if (stack.isEmpty()) {
                    localMax = height2[index] * i;
                } else {
                    localMax = height2[index] * (i - stack.peek() - 1);
                }
                maxArea = Math.max(maxArea, localMax);
            }
        }
        return maxArea;
    }
}