class Solution {
public:
    string reverseVowels(string s) {
        int start = 0, end = s.length() - 1;
        unordered_set<char> vows = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        while (start < end){
            if (!vows.count(s[start])){
                start++;
            }else if (!vows.count(s[end])){
                end--;
            }else{
                swap(s[start], s[end]);
                start++;
                end--;
            }
        }
        return s;
    }
};