public class Solution {
    public String simplifyPath(String path) {
        String[] dir = path.split("/");
        String[] stack = new String[dir.length];
        int ptr = 0;
        for (int i = 0; i < dir.length; i++){
            if (dir[i].equals(".") || dir[i].equals("")){
                continue;
            }else if (dir[i].equals("..")){
                if (ptr > 0)
                    ptr--;
            }else{
                stack[ptr] = dir[i];
                ptr++;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < ptr; i++){
            res.append("/");
            res.append(stack[i]);
        }
        return (res.length() == 0 || res == null) ? "/" : res.toString();
    }
}