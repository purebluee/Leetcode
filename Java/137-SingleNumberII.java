public class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i : nums){
            if (hm.containsKey(i)){
                hm.put(i, hm.get(i) + 1);
                if (hm.get(i) % 3 == 0){
                    hm.remove(i);
                }
            }else{
                hm.put(i, 1);
            }
        }
        return hm.keySet().iterator().next();
    }
}