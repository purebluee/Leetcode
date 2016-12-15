public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int sum = 0, max = 0;
        //Using a hash map to store the sum of all the values before and include nums[i]
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (!map.containsKey(sum)){
                map.put(sum, i);
            }
            if (sum == k){
                max = Math.max(max, i + 1);
            }else if (map.containsKey(sum - k)){
                max = Math.max(max, i - map.get(sum - k));
            }
        }
        return max;
    }
}