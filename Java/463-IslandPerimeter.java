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
        boolean[][] visited = new boolean[n][m];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j]==1) {
                    return countPerimeter(i,j,grid, visited);
                }
            }
        }
        return 0;
    }
    
/*
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]
*/    
    private int countPerimeter(int x, int y, int[][] grid, boolean[][] visited) {
        visited[x][y] = true;
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, 1, -1};
        int perimeter = 0;
        //x = 3, y = 3  grid[3][3]
        //i = 0: grid[2][3]
        //i = 1: grid[4][3]
        //i = 2: grid[3][4]
        //i = 3: grid[3][2]
        for (int i=0; i<dx.length; i++) {
            int movex = x + dx[i];
            int movey = y + dy[i];
            if (inBound(movex, movey, grid)) {
                if (!visited[movex][movey]) {
                    perimeter += countPerimeter(movex, movey, grid, visited);
                }
            } else {
                perimeter++;
            }
        }
        return perimeter;
    }
    
    private boolean inBound(int x, int y, int[][] grid) {
        return (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1);
    }
}