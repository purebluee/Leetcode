public class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        char[] sArr = s.toCharArray();
        for (char c : sArr){
            if (set.contains(c)){
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        return set.size() <= 1;
    }
}