public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length())   return false;
        if (s == null || t == null) return false;
        HashMap<Character, Character> hm = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++){
            if (hm.containsKey(s.charAt(i))){
                if (hm.get(s.charAt(i)) == t.charAt(i)){
                    continue;
                }else{
                    return false;
                }
            }else{
                if (!hm.containsValue(t.charAt(i))){
                    hm.put(s.charAt(i), t.charAt(i));
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}