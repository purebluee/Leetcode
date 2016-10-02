public class Solution {
    //static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (word.charAt(0) == board[i][j] && checkExist(board, word, i, j, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean checkExist(char[][] board, String word, int i, int j, int start, boolean[][] visited){
        if (start == word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
            
        if (!visited[i][j] && word.charAt(start) == board[i][j]){
            visited[i][j] = true;
            boolean res = checkExist(board, word, i+1, j, start+1, visited) || 
                checkExist(board, word, i, j+1, start+1, visited) ||
                checkExist(board, word, i-1, j, start+1, visited) ||
                checkExist(board, word, i, j-1, start+1, visited);
            visited[i][j] = false;
            return res;
        }
        return false;
    }
}