public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for (int i = 1; i < 4 && i < len - 2; i++){
            for (int j = i + 1; j < i + 4 && j < len - 1; j++){
                for (int k = j + 1; k < j + 4 && k < len; k++){
                    String num1 = s.substring(0, i);
                    String num2 = s.substring(i, j);
                    String num3 = s.substring(j, k);
                    String num4 = s.substring(k, len);
                    //System.out.println(num1 + "." + num2 + "." + num3 + "." + num4);
                    if (isValid(num1) && isValid(num2) && isValid(num3) && isValid(num4)){
                        res.add(num1 + "." + num2 + "." + num3 + "." + num4);
                    }
                    
                }
            }
        }
        return res;
    }
    
    private boolean isValid(String s){
        if ((s.charAt(0) == '0' && s.length() > 1) || s == null || s.length() > 3 || s.length() == 0 || 
        Integer.parseInt(s) > 255 || Integer.parseInt(s) < 0){
            return false;
        }
        return true;
    }
}