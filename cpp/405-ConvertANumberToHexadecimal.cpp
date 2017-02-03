class Solution {
public:
    string toHex(unsigned int num) {
        if(!num) return "0";
        string res;
        while(num)
        {
            int ms = num % 16; // num & 15
            if(ms < 10)
                res += '0' + ms;
            else
                res += 'a' + ms - 10;
            num >>= 4; //num /= 16;
        }
        reverse(res.begin(),res.end());
        return res;
    }
};