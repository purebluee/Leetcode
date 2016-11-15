public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int len = tokens.length;
        for (int i = 0; i < len; i++){
            if (tokens[i].equals("+")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 + num2);
            }else if (tokens[i].equals("-")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 - num2);
            }else if (tokens[i].equals("*")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 * num2);
            }else if (tokens[i].equals("/")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                if(num1 == 0){
                    stack.push(0);
                }else{
                    stack.push(num1 / num2);
                }
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        int res = stack.pop();
        return res;
    }
}