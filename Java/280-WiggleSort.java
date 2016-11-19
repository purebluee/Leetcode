//O(nlogn)
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
            if (i % 2 == 1){
                swap(nums, i);
            }
        }
    }
    private void swap(int[]nums, int i){
        int tmp = nums[i];
        nums[i] = nums[i+1];
        nums[i+1] = tmp;
    }
}

//O(n)
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        for (int i = 0; i < nums.length - 1; i++){
            if (i % 2 == 0 && nums[i] > nums[i+1]){
                swap(nums, i);
            }
            if (i % 2 == 1 && nums[i] < nums[i+1]){
                swap(nums, i);
            }
        }
    }
    private void swap(int[]nums, int i){
        int tmp = nums[i];
        nums[i] = nums[i+1];
        nums[i+1] = tmp;
    }
}