public class Solution {
    public void reverseWords(char[] s) {
        //Three steps to reverse words
        //first: reverse whole array;
        reverse(s, 0, s.length-1);
        int start = 0;
        int end = s.length - 1;
        //second: reverse each word
        for (int i = 0; i < s.length; i++){
            if (s[i] == ' '){
                reverse(s, start, i-1);
                start = i + 1;
            }
        }
        //third: reverse the last word: if there is only one word this will solve the corner case
        reverse(s, start, end);
    }
    
    private void reverse(char[] s, int start, int end){
        while (start < end){
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start ++;
            end --;
        }
    }
}