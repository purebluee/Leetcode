public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        if (str == null || str.length() == 0){
            return false;
        }
        int len = str.length();
        for (int i = len / 2; i >= 1; i--){
            if (len % i != 0){
                continue;
            }
            System.out.println(i);
            int n = len / i;
            
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= n; j++){
                sb.append(str.substring(0, i));
            }
            //System.out.println(sb.toString());
            if (sb.toString().equals(str)){
                return true;
            }
        }
        return false;
    }
}