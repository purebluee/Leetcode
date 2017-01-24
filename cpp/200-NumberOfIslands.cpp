class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int count = 0;
        for (int i = 0; i < grid.size(); i++){
            for (int j = 0; j < grid[0].size(); j++){
                if (grid[i][j] == '1'){
                    sink(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    void sink(vector<vector<char>>& grid, int x, int y){
        if (x >= grid.size() || x < 0 || y >= grid[0].size() || y < 0 || grid[x][y] == '0'){
            return;
        }
        grid[x][y] = '0';
        sink(grid, x + 1, y);
        sink(grid, x, y + 1);
        sink(grid, x - 1, y);
        sink(grid, x, y - 1);
    }
};
