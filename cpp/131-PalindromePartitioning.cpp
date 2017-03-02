class Solution {
public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>> res;
        vector<string> curr;
        if (s.size() == 0) {
            return res;
        }
        generate(res, curr, s, 0);
        return res;
    }

    void generate(vector<vector<string>>& res, vector<string>& curr, string& s, int start) {
        if (start == s.size()) {
            res.push_back(curr);
            return;
        }
        for (int i = start; i < s.size(); i++) {
            if (isPal(s, start, i)) {
                curr.push_back(s.substr(start, i - start + 1));
                generate(res, curr, s, i + 1);
                curr.pop_back();
            }
        }
    }

    bool isPal(string s, int i, int j) {
        while (i <= j) {
            if (s[i] != s[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
};
