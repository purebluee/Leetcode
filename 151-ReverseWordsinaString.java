public class Solution {
    public String reverseWords(String s) {
        String[] parts = s.trim().split("(\\s{1,})");
        String out = "";
        //for (int i = parts.length - 1; i > 0; i--){
            //res += parts[i] + " ";
            //}
        for (int i = 1; i < parts.length; i++) {
            out += parts[parts.length-i] + " ";
        }
        return out + parts[0];
    }
}

