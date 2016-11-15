public class Solution {
    //Preferred solution!
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length, p = 0;
        for (int num : nums){
            if (num != val){
                nums[p] = num;
                p++;
            }
        }
        return p;
    }

    //Another one
    public int removeElement1(int[] nums, int val) {
        int start = 0, end = nums.length-1;
        while(start<=end){
            if(nums[start] == val){
                if(nums[end] == val)
                    end--;    
                else{
                    nums[start] = nums[end];
                    start++; end --;
                }
            }else{
                start++;
            }
        }
        System.out.println(start);
        return start;
    }

    //Two Pointers - when elements to remove are rare
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

}