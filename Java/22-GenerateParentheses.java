public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        generate(0, 0, n, result, "");
        return result;
    }
    
    public void generate(int open, int close, int n, List<String> res, String curr){
        if (open == n && close == n){
            //all of the parenthesis are distributed - adding a valid distribution
            res.add(curr);
        }else if (open == n){
            //all of the opening parenthesis are distributed - no other 
            //option than to add the remaining closing parenthesis
            while (close < n){
                curr += ")";
                close ++;
            }
            res.add(curr);
        }else if (close > open){
            //invalid distribution - backtracking
            return;
        }else{
            //on this step it is possible to either add a closing or an opening parenthesis
            generate(open + 1, close, n, res, curr + "(");
            generate(open, close + 1, n, res, curr + ")");
        }
        
    }
}