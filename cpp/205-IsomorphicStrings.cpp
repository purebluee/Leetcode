class Solution {
public:
    bool isIsomorphic(string s, string t) {
        unordered_map<char, char> st;
        unordered_map<char, char> ts;
        if (s.size() != t.size())
            return false;
        for (int i = 0; i < s.size(); i++) {
            if (st.find(s[i]) == st.end() && ts.find(t[i]) == ts.end()) {
                st[s[i]] = t[i];
                ts[t[i]] = s[i];
            } else if (st[s[i]] != t[i] || ts[t[i]] != s[i]) {
                return false;
            }
        }
        return true;
    }
};
