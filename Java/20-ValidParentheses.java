public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '}' && (stack.isEmpty() || stack.pop() != '{')) return false;
            if (c == ']' && (stack.isEmpty() || stack.pop() != '[')) return false;
            if (c == ')' && (stack.isEmpty() || stack.pop() != '(')) return false;
            if (c == '(' || c == '[' || c == '{')   stack.push(c);
        }
        return stack.isEmpty();
    }
}

//not that concise, but makes sense
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