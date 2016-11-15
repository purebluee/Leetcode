public class Solution {
    public int minimumTotal(List<List<Integer>> trgl) {
        int sz = trgl.size();
        int[] results = new int[sz+1];
        for(int i=sz-1; i>=0; i--) {
            List<Integer> tmp = trgl.get(i);
            
            for(int j=0; j<tmp.size(); j++) {
                //System.out.println(results[j] + "!");
                results[j] = Math.min(results[j], results[j+1]) + tmp.get(j);
                //System.out.println(results[j] + "#");
            }
        }
        return results[0];
    }
}