public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] input = preorder.split(",");
        int degree = -1; // root has no indegree, for compensate init with -1
        for (int i = 0; i < input.length; i++){
            String s = input[i];
            degree++; // all nodes have 1 indegree (root compensated)
            if (degree > 0){ // total degree should never exceed 0
                return false;
            }else if (!s.equals("#")){// only non-leaf node has 2 outdegree
                degree -= 2;
            }
        }
        return degree == 0;
    }
}