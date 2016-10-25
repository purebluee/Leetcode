//dfs in place
public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    sink(i, j, grid);
                    count ++;
                }
            }
        }
        return count;
    }
    
    public void sink(int i, int j, char[][] grid){
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        sink(i+1, j, grid);
        sink(i, j+1, grid);
        sink(i-1, j, grid);
        sink(i, j-1, grid);
    }
}

//dfs without modifying input
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (!visited[i][j] && grid[i][j] == '1'){
                    dfs(grid, visited, i, j);
                    count++;
                }
                
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, boolean[][] visited, int i, int j){
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || visited[i][j] || grid[i][j] == '0'){
            return;
        }
        visited[i][j] = true;
        dfs(grid, visited, i+1, j);
        dfs(grid, visited, i-1, j);
        dfs(grid, visited, i, j+1);
        dfs(grid, visited, i, j-1);
    }
}