public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        HashMap<Character, String> hm = new HashMap<>();
        if (pattern.length() != strs.length)    return false;
        for (int i = 0; i < pattern.length(); i ++){
            char c = pattern.charAt(i);
            if (hm.containsKey(c)){
                if (!hm.get(c).equals(strs[i]))
                    return false;
            }else{
                if (hm.containsValue(strs[i]))
                    return false;
                hm.put(c, strs[i]);
            }
        }
        return true;
    }
}