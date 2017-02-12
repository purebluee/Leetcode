/*
[
  "abcd",
  "bnrt",
  "crm",
  "dt"
]
*/
class Solution {
public:
    bool validWordSquare(vector<string>& words) {
        if (words.size() == 0)
            return true;
        if (words.size() != words[0].size())
            return false;
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words[i].size(); j++){
                //be careful here!
                //cout << "i: " << i << " j: " << j << endl;
                if (j >= words.size() || i >= words[j].size() || words[i][j] != words[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
};
