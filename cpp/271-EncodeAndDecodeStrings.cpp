//"aaa", "des", "ea"
//3#aaa3#des2#ea
class Codec {
public:

    // Encodes a list of strings to a single string.
    string encode(vector<string>& strs) {
        string res = "";
        for (auto s : strs) {
            res += to_string(s.size());
            res += "#";
            res += s;
        }
        return res;
    }

    // Decodes a single string to a list of strings.
    //3#nSM3#Dsy
    vector<string> decode(string s) {
        //cout << s << endl;
        vector<string> res;
        int i = 0;
        while (i < s.size()) {
            int token = s.find("#", i);
            int strLen = stoi(s.substr(i, token));
            i = token + 1;
            string currStr = s.substr(i, strLen);
            i += strLen;
            res.push_back(currStr);
        }
        return res;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.decode(codec.encode(strs));
