class Solution {
public:
    bool canPermutePalindrome(string s) {
        unordered_map<char, int> mp;
        for (int i = 0; i < s.size(); i++){
            if (mp.find(s[i]) == mp.end()){
                mp[s[i]] = 1;
            }else{
                mp[s[i]]++;
            }
        }
        int count = 0;
        for (auto i : mp){
            if (i.second % 2 != 0){
                count++;
            }
        }
        return count <= 1;
    }
};
