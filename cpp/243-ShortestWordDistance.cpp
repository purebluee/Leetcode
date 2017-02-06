class Solution {
public:
    int shortestDistance(vector<string>& words, string word1, string word2) {
        int p1 = -1, p2 = -1, minD = INT_MAX;
        for (int i = 0; i < words.size(); i++) {
            if (words[i] == word1) {
                p1 = i;
                if (p2 != -1)
                    minD = min(i - p2, minD);
            }
            if (words[i] == word2) {
                p2 = i;
                if (p1 != -1)
                    minD = min(i - p1, minD);
            }
        }
        return minD == INT_MAX ? -1 : minD;
    }
};
