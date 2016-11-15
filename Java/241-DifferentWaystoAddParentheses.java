public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if (input == null || input.length() == 0){
            return res;
        }
        
        for (int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*'){
                String a = input.substring(0, i);
                String b = input.substring(i + 1);
                List<Integer> left = diffWaysToCompute(a);
                List<Integer> right = diffWaysToCompute(b);
                
                for (int num1 : left){
                    for (int num2 : right){
                        int val = calculate(num1, num2, c);
                        res.add(val);
                    }
                }
            }
        }
        
        //only contains one number
        if (res.isEmpty()){
            res.add(Integer.parseInt(input));
        }
        
        return res;
    }
    
    private int calculate(int num1, int num2, char operator){
        int res = 0;
        switch(operator){
            case '+': res = num1 + num2;
            break;
            
            case '-': res = num1 - num2;
            break;
            
            case '*': res = num1 * num2;
            break;
        }
        return res;
    }
}