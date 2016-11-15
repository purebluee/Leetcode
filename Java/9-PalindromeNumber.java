public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)  return false;
        if (x / 10 == 0)  return true;
        int a = x, newX = 0;
        while(a > 0){
            newX = newX * 10 + a % 10;
            a = a / 10;
        }   
        return newX == x;
    }
}
/*
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)  return false;
        if (x / 10 == 0)  return true;
        int a = x, newX = 0;
        while (a > 0){
            newX = newX * 10 + newX % 10;
            a /= 10;
        }
        return (x == newX);
    }
}
*/