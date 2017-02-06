class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) {
            return false;
        }
        unordered_map<char, int> hm;
        for (char c : s) {
            if (hm.find(c) != hm.end()) {
                hm[c]++;
            }else{
                hm[c] = 1;
            }
        }
        for (char c : t) {
            if (hm.find(c) == hm.end() || hm[c] <= 0) {
                return false;
            }else {
                hm[c]--;
            }
        }
        for (auto i : hm) {
            if (i.second) {
                return false;
            }
        }
        return true;
    }
};
