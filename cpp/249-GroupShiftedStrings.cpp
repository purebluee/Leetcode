class Solution {
public:
    vector<vector<string>> groupStrings(vector<string>& strings) {
        unordered_map<string, vector<string>> umap;
        vector<vector<string>> res;
        for (int i = 0; i < strings.size(); i++) {
            string tmp = strings[i];
            int beginning = tmp[0] - 'a';
            //attention! the for loop
            for (int j = 0; j < tmp.size(); j++) {
                tmp[j] -= beginning;
                if (tmp[j] - 'a' < 0) {
                    tmp[j] += 26;
                }
            }
            umap[tmp].push_back(strings[i]);
        }
        for (auto pair : umap) {
            res.push_back(pair.second);
        }
        return res;
    }
};
