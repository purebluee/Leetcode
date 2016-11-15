public class NumArray {
    private int[] numsSum;
    
    public NumArray(int[] nums) {
        numsSum = nums;
        for (int i = 1; i < nums.length; i++)
            numsSum[i] += nums[i - 1];
    }

    public int sumRange(int i, int j) {
        
        if (i == 0) return numsSum[j];
        return numsSum[j] - numsSum[i-1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);