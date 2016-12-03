public class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0)
            return false;
        Map<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        map.put('0', '0');
        int len = num.length();
        int start = 0, end = len - 1;
        while (start <= end){//<- why <=? for corner case: if only one number
            if (!map.containsKey(num.charAt(start))){
                return false;
            }
            if (map.get(num.charAt(start)) != num.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}