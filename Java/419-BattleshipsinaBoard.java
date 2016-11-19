public class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (i < board.length - 1 && board[i + 1][j] == 'X'){
                    continue;
                }
                if (j < board[0].length - 1 && board[i][j + 1] == 'X'){
                    continue;
                }
                if (board[i][j] == '.'){
                    continue;
                }
                count++;
            }
        }
        return count;
    }
}