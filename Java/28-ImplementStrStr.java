public class Solution {
    public int strStr(String haystack, String needle) {
        if ((haystack == null && needle == null) || needle.length() == 0 || haystack.equals(needle)){
            return 0;
        }
        if (haystack == null || needle == null || haystack.length() < needle.length()){
            return -1;
        }
        int m = haystack.length(), n = needle.length();
        
        for (int i = 0; i < m; i++){
            if (i + n > m){
                break;
            }
            if (haystack.substring(i, i + n).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}