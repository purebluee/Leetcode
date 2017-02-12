class Solution {
public:
    int strStr(string haystack, string needle) {
        if (haystack.size() < needle.size())
            return -1;
        if (needle.size() == 0 || needle == haystack)
            return 0;
        //attention! <= last char inclusive!
        for (int i = 0; i <= haystack.size() - needle.size(); i++) {
            //cout << haystack.substr(i, needle.size()) << endl;
            if (haystack.substr(i, needle.size()) == needle)
                return i;
        }
        return -1;
    }
};
