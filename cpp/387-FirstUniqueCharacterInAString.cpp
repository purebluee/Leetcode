class Solution {
public:
    int firstUniqChar(string s) {
        //-2: duplicated; -1: initial val, since index might be 0
        int count[26] = {};
        for (int i = 0; i < 26; i++)
            count[i] = -1;
        for (int i = 0; i < s.size(); i++) {
            if (count[s[i] - 'a'] == -1) {
                count[s[i] - 'a'] = i;
            } else if (count[s[i] - 'a'] >= 0) {
                count[s[i] - 'a'] = -2;
            }
        }
        int first = INT_MAX;
        for (int c : count) {
            if (c >= 0)
                first = min(first, c);
        }
        return first == INT_MAX ? -1 : first;
    }
};
