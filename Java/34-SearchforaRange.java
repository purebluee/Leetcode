//Non optimal: apply two times of binary search
//If you can find first, you don't have to start from position 0 to find last.
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
    
    private int findLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
}

//Easier to understand:
public class Solution {
   public  int[] searchRange(int[] nums, int target) {
        int hi = nums.length - 1;
        int low = 0;
        int[] rs = new int[2];
       // base case
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1 };
        
       //left side
        while(low < hi){
            int mid = low + (hi - low) /2;
            if(target > nums[mid]){
                low = mid + 1;
            }else{
                hi = mid;
            }
        }
        if(target == nums[low]){
            rs[0] = low;
        }else{
            rs[0] = -1;
        }
       
        //right side
        hi = nums.length - 1;
        while(low < hi){
            int mid = (low + (hi - low) /2 ) + 1;
            
            if(target < nums[mid]){
                hi = mid - 1;
            }else{
                low = mid;
            }
        }   
        if(target == nums[hi]){
            rs[1] = hi;
        }else{
            rs[1] = -1;
        }
        
        return rs;
    }
}