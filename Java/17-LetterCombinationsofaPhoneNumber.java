public class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> res = new ArrayList<>();
        if (digits.length() == 0)    return res;
        String[] letterMap = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++){
            List<String> temp = new ArrayList<>();
            //int curr = Character.getNumericValue(digits[i]);
            int curr = digits.charAt(i) - '0';
            String chars = letterMap[curr];
            for (int x = 0; x < chars.length(); x++){
                for(int j = 0; j < res.size(); j++){
                    temp.add(res.get(j)+chars.charAt(x));
                }
            }
            res = temp;
        }
        return res;
    }
}