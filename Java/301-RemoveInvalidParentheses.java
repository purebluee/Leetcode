//BFS
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if (s == null){
            return null;
        }
        Queue<String> q = new LinkedList<>();
        List<String> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        q.add(s);
        visited.add(s);
        boolean found = false;
        while (!q.isEmpty()){
            s = q.poll();
            if (isValid(s)){
                res.add(s);
                found = true;
            }
            if (!found){
                for (int i = 0; i < s.length(); i++){
                    if (s.charAt(i) != '(' && s.charAt(i) != ')'){
                        continue;
                    }
                    String tmp = s.substring(0, i) + s.substring(i+1, s.length());
                    if (!visited.contains(tmp)){
                        visited.add(tmp);
                        q.add(tmp);
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isValid(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++){
             if (s.charAt(i) == '('){
                 count++;
             }else if (s.charAt(i) == ')'){
                 if (count == 0){
                     return false;
                 }
                 count--;
             }
        }
        return count == 0;
    }
}