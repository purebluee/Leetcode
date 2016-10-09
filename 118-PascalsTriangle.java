public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            List<Integer> insideArr = new ArrayList<>();
            for (int j = 0; j < i+1; j++){
                if (j == 0 || j == i){
                    insideArr.add(1);
                }else{
                    insideArr.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
            }
            res.add(insideArr);
        }
        return res;
    }
}