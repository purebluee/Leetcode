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
