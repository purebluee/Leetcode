class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.size() == 0) {
            return "";
        }
        string res = strs[0];
        for (int i = 1; i < strs.size(); i++) {
            //res is the shorter string
            for (int j = 0; j < res.size(); j++) {
                if (strs[i][j] != res[j]) {
                    res = res.substr(0, j);
                }
            }
        }
        return res;
    }
};
