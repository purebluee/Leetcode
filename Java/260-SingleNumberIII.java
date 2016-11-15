public class Solution {
    public int[] singleNumber(int[] nums) {
        // go through the array and XOR every element, for example, result = 6 (3^5)
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            result ^= nums[i];
        }
        // notice that 6^5 = 3, 6^3 = 5
        // now how to find 3 and 5 from 6
        int[] r = new int[2];
        // find the lowest bit of the result
        // let's say 6 (0110), -6 = 1010  0110 & 1010 = 0010
        int lowbit = result & -result;
        // since this bit from the result is 1, we can be sure that 
        // a & lowbit and b & lowbit have different result
        for(int n : nums){
            if((n & lowbit) == 0) r[0] ^= n;
            else r[1] ^=n;
        }
        return r;
    }

    //HashSet solution
    public int[] singleNumberHashSet(int[] nums) {
        int[] res = new int[2];
        if (nums.length == 0 || nums == null)
            return res;
        Set<Integer> hs = new HashSet<>();
        for (int n : nums){
            if (hs.contains(n)){
                hs.remove(n);
            }else{
                hs.add(n);
            }
        }
        int i = 0;
        for (int n : hs){
            res[i] = n;
            i++;
        }
        return res;
    }

}