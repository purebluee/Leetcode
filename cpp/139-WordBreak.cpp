class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        vector<bool> dp(s.size() + 1, false);
        dp[0] = true;
        unordered_set<string> wordSet(wordDict.begin(), wordDict.end());
        //i: current string;
        //j: breaking point of current string
        //dp[0]: if string is null
        for (int i = 1; i <= s.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordSet.find(s.substr(j, i - j)) != wordSet.end() && dp[j]) {
                    //cout << s.substr(i, j) << endl;
                    dp[i] = true;
                    if (dp[s.size()]) {
                        return true;
                    }
                }
            }
        }
        return dp[s.size()];
    }
};
