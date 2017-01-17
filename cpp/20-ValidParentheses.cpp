class Solution {
public:
    bool isValid(string s) {
        stack<char> stack;
        unordered_set<char> left = {'(', '{', '['};
        unordered_set<char> right = {')', '}', ']'};
        for (auto c : s){
            if (left.count(c)){
                stack.push(c);
            }else{
                if (stack.empty()){
                    return false;
                }
                if (c != ')' && stack.top() == '('){
                    return false;
                }
                if (c != '}' && stack.top() == '{'){
                    return false;
                }
                if (c != ']' && stack.top() == '[]'){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }
};