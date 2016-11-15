class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        
        vector<int> res;
        if (matrix.empty() || matrix.size() == 0){
            return res;
        }
        int bottom = matrix.size() -1;
        int right = matrix[0].size() - 1;
        int top = 0, left = 0;
        while (top <= bottom && left <= right){
            for (int i = left; i <= right; i++){
                res.push_back(matrix[top][i]);
            }
            top++;
            if (top > bottom){
                break;
            }
            for (int i = top; i <= bottom; i++){
                res.push_back(matrix[i][right]);
            }
            right--;
            if (left > right){
                break;
            }
            for (int i = right; i >= left; i--){
                res.push_back(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top; i--){
                res.push_back(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
};