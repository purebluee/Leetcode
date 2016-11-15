public class Solution {
    public boolean isPalindrome(String s) {
        if (s.equals(""))  return true;
        int head = 0, tail = s.length() - 1;
        while (head <= tail){
            char charH = s.charAt(head);
            char charT = s.charAt(tail);
            if (!Character.isLetterOrDigit(charH)){
                head++;
            }else if (!Character.isLetterOrDigit(charT)){
                tail--;
            }else if (Character.toLowerCase(charH) == Character.toLowerCase(charT)){
                head++;
                tail--;
            }else
                return false;
            
        }
        return true;
    }
}