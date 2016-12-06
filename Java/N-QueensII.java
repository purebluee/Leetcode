/**
 * don't need to actually place the queen,
 * instead, for each row, try to place without violation on
 * col/ diagonal1/ diagnol2.
 * trick: to detect whether 2 positions sit on the same diagnol:
 * if delta(col, row) equals, same diagnol1;
 * if sum(col, row) equals, same diagnal2.
 */
public class Solution {
    Set<Integer> occupiedCols = new HashSet<Integer>();
    Set<Integer> occupiedDiag1s = new HashSet<Integer>();
    Set<Integer> occupiedDiag2s = new HashSet<Integer>();
    public int totalNQueens(int n) {
        return totalNQueensHelper(0, 0, n);
    }
    
    private int totalNQueensHelper(int row, int count, int n) {
        for (int col = 0; col < n; col++) {
            if (occupiedCols.contains(col))
                continue;
            int diag1 = row - col;
            if (occupiedDiag1s.contains(diag1))
                continue;
            int diag2 = row + col;
            if (occupiedDiag2s.contains(diag2))
                continue;
            // we can now place a queen here
            if (row == n-1)
                count++;
            else {
                occupiedCols.add(col);
                occupiedDiag1s.add(diag1);
                occupiedDiag2s.add(diag2);
                count = totalNQueensHelper(row+1, count, n);
                // recover
                occupiedCols.remove(col);
                occupiedDiag1s.remove(diag1);
                occupiedDiag2s.remove(diag2);
            }
        }
        
        return count;
    }
}

//Iterative
public class Solution {
    private int result = 0;
    public int totalNQueens(int n) {
        if (n == 0 || n == 2 || n == 3) {
            return 0;
        }
        int[] cols = new int[n];
        totalNQueensHelper(n, 0, cols);
         
        return result;
    }
     
    private void totalNQueensHelper(int n, int row, int[] cols) {
        if (row == n) {
            result++;
            return;
        }
         
        for (int j = 0; j < n; j++) {
            if (isValid(j, row, cols)) {
                cols[row] = j; 
                totalNQueensHelper(n, row + 1, cols);
            }
        }
    }
     
    private boolean isValid(int col, int rows, int[] cols) {
        for (int i = 0; i < rows; i++) {
            if (cols[i] == col || rows - i == Math.abs(cols[i] - col)) {
                return false;
            }
        }
        return true;
    }
}