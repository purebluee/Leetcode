public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        int[] ways = new int[len + 1];
        ways[0] = 1; //empty string: one way to decode
        ways[1] = s.charAt(0) == '0' ? 0 : 1; //string size of 1
        for (int i = 2; i <= len; i ++){
            int num1 = Integer.parseInt(s.substring(i-1, i)); //single digit
            int num2 = Integer.parseInt(s.substring(i-2, i)); //two digits
            if (num1 != 0){
                ways[i] += ways[i-1];
            }
            if (num2 >= 10 && num2 <= 26){
                ways[i] += ways[i-2];
            }
        }
        return ways[len];
    }
}