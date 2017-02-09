//1234321
//121
class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x / 10 == 0)
            return true;
        int newX = 0, num = x;
        while (num) {
            newX = newX * 10 + num % 10;
            num /= 10;
        }
        return newX == x;
    }
};
