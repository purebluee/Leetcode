public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (hm.containsKey(target - nums[i])){
                result[1] = i;
                result[0] = hm.get(target - nums[i]);
                return result;
            }
            hm.put(nums[i], i);
        }
        return result;
    }
}