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