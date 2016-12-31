//with hashSet
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0 || haystack.equals(needle)){
            return 0;
        }
        if (haystack == null || haystack.length() == 0 || haystack.length() < needle.length()){
            return -1;
        }
        Set<String> set = new HashSet<>();
        int m = haystack.length(), n = needle.length();

        set.add(needle);
        for (int i = 0; i <= m - n; i++){
            if (set.contains(haystack.substring(i, i + n))){
                return i;
            }
        }
        return -1;
    }
}

//without hashset
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0 || haystack.equals(needle)){
            return 0;
        }
        if (haystack == null || haystack.length() == 0 || haystack.length() < needle.length()){
            return -1;
        }
        int m = haystack.length(), n = needle.length();
        
        for (int i = 0; i <= m - n; i++){
            if (haystack.substring(i, i + n).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}