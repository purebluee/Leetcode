public class Solution {
    public String reverseVowels(String s) {
        if (s.length() == 0 || s == null){
            return s;
        }
        String vowels = "aeiouAEIOU";
        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();

        while (start < end){
            while (!vowels.contains(chars[start]+"") && start < end){
                start ++;
            }
            while (!vowels.contains(chars[end]+"") && start < end){
                end --;
            }
            
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start ++;
            end --;
        }
        return new String(chars);
    }
}