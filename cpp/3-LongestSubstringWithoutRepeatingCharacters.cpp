//pwwkew
//012345
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> hm;
        int maxL = 0;
        int start = -1;
        for (int i = 0; i < s.size(); i++) {
            if (hm.find(s[i]) != hm.end()) {
                start = max(start, hm[s[i]]);
            }
            hm[s[i]] = i;
            maxL = max(maxL, i - start);
        }
        return maxL;
    }
};
