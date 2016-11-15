
public class Solution {
    //SUM
    public int missingNumberSUM(int[] nums) {
        int len = nums.length;
        int sum = (0 + len) * (len + 1) / 2;
        for (int i = 0; i < len; i++){
            sum -= nums[i];
        }
        return sum;
   }

    //XOR
    public int missingNumberXOR(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++){
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }

    //Binary search
    public int missingNumberBin(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length;
        while (start < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] > mid){
                end = mid;
            }else
                start = mid+1;
        }
        return start;
    }
}
