//note that this solution is essentially the partition() method in quicksort, applied on both left and right side at the same time
public class Solution {
    public void sortColors(int[] nums) {
        int red=0;
        int blue=nums.length-1;
        for(int i=0; i<=blue && i < nums.length;) {
            if (nums[i] == 0 && i > red ) {
                swap(nums,i,red);
                red++;
            } else if (nums[i] == 2 && i < blue){
                swap(nums,i,blue);
                blue--;
            }
            else
                i++;
        }
    }
    
    private void swap(int nums[], int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}