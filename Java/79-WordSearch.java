public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || 
        word == null || word.length() == 0){
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (search(board, word, i, j, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, String word, int x, int y, int start, boolean[][] visited){
        if (start == word.length()){
            return true;
        }
        if (x >= board.length || x < 0 || y >= board[0].length || y < 0){
            return false;
        }
        if (visited[x][y] || board[x][y] != word.charAt(start)){
            return false;
        }
        visited[x][y] = true;
        boolean res = search(board, word, x + 1, y, start + 1, visited) ||
        search(board, word, x, y + 1, start + 1, visited) ||
        search(board, word, x - 1, y, start + 1, visited) ||
        search(board, word, x, y - 1, start + 1, visited);
        visited[x][y] = false;
        return res;
    }
}