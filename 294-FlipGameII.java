public class Solution {
    public boolean canWin(String s) {
        if (s.length() < 2 || s == null)
            return false;
        for (int i = 0; i < s.length() - 1; i++){
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+'){
                String tmp = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!canWin(tmp)){
                    return true;
                }
            }
        }
        return false;
    }
}