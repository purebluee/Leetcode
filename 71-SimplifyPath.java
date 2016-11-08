public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0){
            return path;
        }
        String[] pathArray = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String p : pathArray){
            if (p.equals("") || p.equals(".")){
                continue;
            }
            if (p.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(p);
            }
        }
        String res = "";
        if (stack.isEmpty()){
            res = "/";
        }
        while (!stack.isEmpty()){
            res = "/" + stack.pop() + res;
        }
        return res;
    }
}