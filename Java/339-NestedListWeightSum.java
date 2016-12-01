/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }
    private int depthSum(List<NestedInteger> nestedList, int depth){
        int res = 0;
        for (NestedInteger n : nestedList){
            res += n.isInteger() ? n.getInteger() * depth : depthSum(n.getList(), depth + 1);
        }
        return res;
    }
}

//Iterative:
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null){
            return 0;
        }
        int sum = 0, depth = 1;
        Queue<NestedInteger> q = new LinkedList<>(nestedList);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                NestedInteger n = q.poll();
                if (n.isInteger()){
                    sum += depth * n.getInteger();
                }else{
                    q.addAll(n.getList());
                }
            }
            depth++;
        }
        return sum;
    }
}