public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()){
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        s = new String(chars);
        t = new String(chart);
        return s.equals(t);
    }

    public boolean isAnagramSol2(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int[] count = new int['z' - 'a' + 1];
        for (char c : s.toCharArray()){
            count[c - 'a']++;
        }
        for (char d : t.toCharArray()){
            count[d - 'a']--;
        }
        for (int i = 0; i < count.length; i++){
            if (count[i] != 0){
                return false;
            }
        }
        return true;
    }    
} 