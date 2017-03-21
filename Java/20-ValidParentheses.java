public class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if ((curr == '}' || curr == ']' || curr == ')') && stack.isEmpty()) 
                return false;
            if (curr == '}' && stack.peek() != '{')
                return false;
            if (curr == ']' && stack.peek() != '[')
                return false;
            if (curr == ')' && stack.peek() != '(')
                return false;
            if (curr == '{' || curr == '(' || curr == '[') {
                stack.push(curr);
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

//another solution
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        List<Character> left = Arrays.asList('(', '{', '[');
        List<Character> right = Arrays.asList(')', '}', ']');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if (left.contains(curr)){
                stack.push(curr);
            }else if (!stack.isEmpty()){
                if (stack.peek() == left.get(right.indexOf(curr))){
                    stack.pop();
                    continue;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }
}