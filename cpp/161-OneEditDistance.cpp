//"abcdef"
//"abcef"
class Solution {
public:
    bool isOneEditDistance(string s, string t) {
        int slen = s.size(), tlen = t.size();
        int index = 0;

        if (slen == 0 && tlen == 0 || abs(slen - tlen) > 1 || s == t)
            return false;
        //substitute
        if (slen == tlen) {
            for (; index < slen; index++) {
                if (s[index] != t[index]) {
                    break;
                }
            }
            return s.substr(index+1, slen) == t.substr(index+1, tlen);
        }

        //remove
        index = 0;
        for (; index < slen; index++) {
            if (s[index] != t[index]) {
                break;
            }
        }
        if (slen > tlen) {
            return s.substr(index+1, slen) == t.substr(index, tlen);
        } else {
            return s.substr(index, slen) == t.substr(index+1, tlen);
        }
    }
};
