/*The solution is straightforward:

If grid[i][j] is 1, then check the four neighbors of (i, j) to see how many of them are 1. Assume the number of 1's of the four neighbors are k (0=<k<=4), then the perimeter is added by (4 - k).
*/
public class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int perimeter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        perimeter -= 1;
                    }
                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        perimeter -= 1;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter -= 1;
                    }
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        perimeter -= 1;
                    }
                }
            }
        }
        return perimeter;
    }
}

/*
Used depth first search to traverse through all islands. Inside recursion for each island calculated its perimeter.
*/
public class Solution {
    
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean used[][] = new boolean[n][m];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j]==1) {
                    return countPerimeter(i,j,grid, used);
                }
            }
        }
        return 0;
    }
    
    private int countPerimeter(int x, int y, int [][] grid, boolean used[][]) {
        used[x][y] = true;
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, 1, -1};
        int perimeter = 0;
        for (int i=0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (inBound(nx, ny, grid)) {
                if (!used[nx][ny]) {
                    perimeter += countPerimeter(nx, ny, grid, used);
                }
            } else {
                perimeter++;
            }
        }
        return perimeter;
    }
    
    private boolean inBound(int x, int y, int [][] grid) {
        return (x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]==1);
    }
}