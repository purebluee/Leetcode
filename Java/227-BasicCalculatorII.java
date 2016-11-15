public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0, num = 0, sign = '+';
        
        for (int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            
            if (Character.isDigit(curr)){
                num = num * 10 + (curr - '0');
            }
            
            if ((curr != ' ' && !Character.isDigit(curr)) || i == s.length() - 1){
                if (sign == '+'){
                    stack.push(num);
                }
                if (sign == '-'){
                    stack.push(-num);
                }
                if (sign == '*'){
                    stack.push(stack.pop() * num);
                }
                if (sign == '/'){
                    stack.push(stack.pop() / num);
                }
                sign  = curr;
                num = 0;
            }
        }
        
        for (int i : stack){
            res += i;
        }
        return res;
    }
}