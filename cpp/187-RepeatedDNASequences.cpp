class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        unordered_map<string, int> map;//records the counting of DNA sequence
        vector<string> res;
        if (s.size() <= 10){
            return res;
        }
        for (int i = 0; i <= s.size() - 10; i++){
            string seq = s.substr(i, 10);
            if (map.find(seq) == map.end()){
                map[seq] = 1;
            }else if (map[seq] == 1){
                res.push_back(seq);
                map[seq]++;
            }else{
                map[seq]++;
            }
        }
        return res;
    }
};
