public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0){ //Empty array misses the range lower->upper.
            result.add(outputRange(lower, upper));
            return result;
        }
        int start = 0;
        if (nums[0] > lower){ //Handles lower boundary. Notice "inclusive".
            result.add(outputRange(lower, nums[0] - 1));
            start = nums[0];
        }else{
            start = lower;
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] - start > 1){
                result.add(outputRange(start + 1, nums[i] - 1));//Misses range if distance > 1.
            }
            start = nums[i];
        }
        if (upper - start > 0){//handles upper bound
            result.add(outputRange(start + 1, upper));
        }
        return result;
    }
    
    private String outputRange(int lower, int upper){
        return (lower == upper ? lower + "" : lower + "->" + upper);
    }
    
}