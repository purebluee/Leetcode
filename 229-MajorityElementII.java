public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        
        int candidate1 = nums[0], candidate2 = nums[0];
        int count1 = 1, count2 = 0;
        
        for (int num : nums){
            if (num == candidate1){
                count1 ++;
            }else if (num == candidate2){
                count2 ++;
            }else if (count1 == 0){
                candidate1 = num;
                count1 ++;
            }else if (count2 == 0){
                candidate2 = num;
                count2 ++;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        
        for (int num : nums){
            if ( num == candidate1){
                count1 ++;
            }else if (num ==candidate2){
                count2 ++;
            }
        }
        System.out.println(candidate1 + " " + candidate2);
        if (count1 > nums.length/3){
            res.add(candidate1);
        }
        if (count2 > nums.length/3){
            res.add(candidate2);
        }
        return res;
    }
}