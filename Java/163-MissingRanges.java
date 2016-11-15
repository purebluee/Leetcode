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

//longer...
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums == null){
            return res;
        }
        if (nums.length == 0){
            if (lower == upper){
                res.add(Integer.toString(lower));
            }else{
                res.add(generateInterval(lower, upper));
            }
            return res;
        }
        
        if (nums[0] != lower){
            if (lower == nums[0] - 1){
                res.add(Integer.toString(lower));
            }else{
                res.add(generateInterval(lower, (nums[0] - 1)));
            }
        }
        int next = nums[0] + 1;
        
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i-1]){
                continue;
            }
            if (nums[i] == next){
                next++;
                continue;
            }else{
                if (nums[i] - next == 1){
                    res.add(Integer.toString(next));
                }else{
                    res.add(generateInterval(next, nums[i] - 1));
                }
            }
            next = nums[i] + 1;
        }
        if (nums[nums.length - 1] != upper){
            System.out.println(upper + " " + next);
            if (nums.length == 1){
                if (nums[0] == upper - 1){
                    res.add(Integer.toString(upper));
                }else{
                    res.add(generateInterval(next, upper));
                }
            }else{
                if (upper == next){
                    res.add(Integer.toString(next));
                }else{
                    res.add(generateInterval(next, upper));
                }
            }
        }
        return res;
    }
    
    private String generateInterval(int lower, int upper){
        return lower + "->" + upper;
    }
}