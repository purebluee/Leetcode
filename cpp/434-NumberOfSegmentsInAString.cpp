class Solution {
public:
    int countSegments(string s) {
        if (s.size() == 0)
            return 0;
        int count = 0;
        int start = 0;
        while (s[start] == ' ')
            start++;
        for (int i = start; i < s.size(); i++) {
            if (s[i] != ' ' && (i == 0 || s[i - 1] == ' '))
                count++;
        }
        return count;
    }
};
