class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> res;
        unordered_map<string, vector<string>> umap;
        for (string str : strs) {
            string tmp = str;
            sort(tmp.begin(), tmp.end());
            umap[tmp].push_back(str);
        }
        for (auto pair : umap) {
            res.push_back(pair.second);
        }
        return res;
    }
};
