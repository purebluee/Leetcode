public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        int max = 1;
        for (int num : nums){
            int left = num - 1;
            int right = num + 1;
            int count = 1;
            while (set.contains(left)){
                count++;
                set.remove(left);
                left--;
            }
            while (set.contains(right)){
                count++;
                set.remove(right);
                right++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}