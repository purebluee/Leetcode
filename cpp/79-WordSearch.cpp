class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        int m = board.size(), n = board[0].size();

        vector<vector<bool>> visited(m, vector<bool>(n, false));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (checkWord(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    bool checkWord(vector<vector<char>>& board, string& word, vector<vector<bool>>& visited, int x, int y, int currChar) {
        if (currChar == word.size()) {
            return true;
        }

        if (x >= board.size() || x < 0 || y >= board[0].size() || y < 0) {
            return false;
        }

        if (visited[x][y] || board[x][y] != word[currChar]) {
            return false;
        }

        if (board[x][y] == word[currChar]) {
            visited[x][y] = true;
            bool res = checkWord(board, word, visited, x + 1, y, currChar+1) ||
            checkWord(board, word, visited, x - 1, y, currChar+1) ||
            checkWord(board, word, visited, x, y + 1, currChar+1) ||
            checkWord(board, word, visited, x, y - 1, currChar+1);
            visited[x][y] = false;
            return res;
        }
    }
};
