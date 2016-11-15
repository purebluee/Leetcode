public class Solution {
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++){
            if (Character.isLetter(s.charAt(i))){
                count[s.charAt(i) - 'a']++;
            }
        }
        for (int i = 0; i < t.length(); i++){
            if (Character.isLetter(t.charAt(i))){
                count[t.charAt(i) - 'a']--;
            }
        }
        for (int i = 0; i < count.length; i++){
            if (count[i] != 0){
                return (char)('a' + i);
            }
        }
        return ' ';
    }
}