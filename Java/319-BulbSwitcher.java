/*
4 = 2^2: on

8 = 2^3: off

36 = 2^2 * 3^2: on

a number is on, if its factors have even power, in other words, if it is a square
*/
public class Solution {
    public int bulbSwitch(int n) {
        int on = 0;
        for (int i = 1; i * i <= n; i++)    {
            on++;
        }
            
        return on;
    }
}