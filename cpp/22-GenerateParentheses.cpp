class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> res;
        if (n == 0) {
            res.push_back("");
            return res;
        }
        generate(n, res, "", 0, 0);
        return res;
    }

    void generate(int n, vector<string>& res, string curr, int open, int close) {
        if (open == n && close == n) {
            res.push_back(curr);
        } else if (open == n && close < n) {
            while (close < n) {
                curr += ")";
                close++;
            }
            res.push_back(curr);
        } else if (close > open) {
//      not right below!!
//        } else if (open != n && close == n) {
            return;
        } else {
            generate(n, res, curr + "(", open + 1, close);
            generate(n, res, curr + ")", open, close + 1);
        }
    }
};
