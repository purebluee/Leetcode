public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<List<Integer>>(numRows);
        for (int i = 0; i < numRows; ++i){
            List<Integer> insideArr = new ArrayList<Integer>();
            for (int j = 0; j < i; ++j){
                if (j == 0 || j == i){
                    insideArr.add(1);
                }else{
                    insideArr.add(
                        pascal.get(i-1).get(j-1) + 
                        pascal.get(i-1).get(j));
                }
            }
            pascal.add(insideArr);
        }
        return pascal;
    }
}