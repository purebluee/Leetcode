//note that this solution is essentially the partition() method in quicksort, applied on both left and right side at the same time
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null)
            return;
        int p1 = 0, p2 = nums.length - 1, curr = 0;
        while (curr <= p2 && curr < nums.length){
            if (nums[curr] == 0 && curr > p1){
                swap(nums, curr, p1);
                p1++;
            }
            else if (nums[curr] == 2 && curr < p2){
                swap(nums, curr, p2);
                p2--;
            }else{
                curr++;
            }
        }
    }
    
    private void swap(int[] nums, int p1, int p2){
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }
}