//harder to understand
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> hm = new HashMap<>();
        int ans = 0;
        for (int i = 0, j = 0; j < n; j++){
            if (hm.containsKey(s.charAt(i))){
                i = Math.max(hm.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            hm.put(s.charAt(j), j+1);
        }
        return ans;
    }
}