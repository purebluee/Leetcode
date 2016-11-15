public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        if (nums.length == 0 || nums == null)   return res;
        boolean[] visited = new boolean[nums.length];
        permute(nums, res, curr, visited);
        return res;
    }
    private void permute(int[] nums, List<List<Integer>> res, List<Integer> curr, boolean[] visited){
        if (curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < visited.length; i++){
            if (!visited[i]){
                if (i > 0 && nums[i] == nums[i-1] && visited[i-1]){
                    return;
                }
                visited[i] = true;
                curr.add(nums[i]);
                permute(nums, res, curr, visited);
                curr.remove(curr.size()-1);
                visited[i] = false;
            }
        }
    }
}