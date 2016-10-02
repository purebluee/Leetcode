public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || haystack == null || haystack.length() < needle.length()) return -1;
        for (int i = 0; i <= haystack.length() - needle.length(); ++i){
            if (haystack.substring(i, i+needle.length()).equals(needle))    return i;
        }
        return -1;
    }
}