//Input:Digit string "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
class Solution {
public:
    vector<string> letterCombinations(string digits) {
        vector<string> res;
        string dict[] = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if (digits.empty())
            return res;
        res.push_back("");
        for (int i = 0; i < digits.size(); i++) {
            int currDigit = digits[i] - '0';
            string currLetters = dict[currDigit];
            vector<string> tmp;
            for (int j = 0; j < currLetters.size(); j++) {
                for (int k = 0; k < res.size(); k++) {
                    tmp.push_back(res[k] + currLetters[j]);
                }
            }
            res = tmp;
        }
        return res;
    }
};
