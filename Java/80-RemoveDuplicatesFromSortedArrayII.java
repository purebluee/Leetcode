public class Solution {
    public int removeDuplicates(int[] nums) {
        int counter = 0;//count number of unique numbers
        for (int n : nums){
            if (counter < 2 || n > nums[counter-2]){
                nums[counter] = n;
                counter++;
            }
        }
        return counter;
    }
}