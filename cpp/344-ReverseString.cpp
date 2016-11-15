class Solution {
public:
    string reverseString(string s) {
        
        int start = 0, end = s.size() - 1;
        while (start <= end){
            char tmp = s.at(start);
            s.at(start) = s.at(end);
            s.at(end) = tmp;
            start++;
            end--;
        }
        return s;
    }
};