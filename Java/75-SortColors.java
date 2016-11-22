/*
The question asks for solving the problem using only one pass of the array. Since the array is only 
composed of 0, 1, and 2, we can naturally think of using two pointers approach. We use two pointers, 
red and blue, points to the starting and end of the array initially. Then iterate index i from 0 to 
the end of the array. If A[i] == 0, move it to red pointer. If A[i] == 2, move it to blue pointer. 
Else move on. 
*/
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null)
            return;
        int p1 = 0, p2 = nums.length - 1, curr = 0;
        while (curr <= p2){
            if (nums[curr] == 0){
                swap(nums, curr, p1);
                p1++;
                curr++;
            }
            else if (nums[curr] == 2){
                swap(nums, curr, p2);
                p2--;
            }else{
                curr++;
            }
        }
    }
    
    private void swap(int[] nums, int p1, int p2){
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }
}

//solution 2:
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null)
            return;
        int p1 = 0, p2 = nums.length-1, curr = 0;
        while (curr <= p2){
            if (nums[curr] == 0){
                nums[curr] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            else if (nums[curr] == 2){
                nums[curr] = nums[p2];
                nums[p2] = 2;
                curr--;
                p2--;
            }
            curr++;
        }
    }
}



// two pass O(m+n) space
void sortColors(int nums[], int n) {
    int num0 = 0, num1 = 0, num2 = 0;
    
    for(int i = 0; i < n; i++) {
        if (nums[i] == 0) ++num0;
        else if (nums[i] == 1) ++num1;
        else if (nums[i] == 2) ++num2;
    }
    
    for(int i = 0; i < num0; ++i) 
        nums[i] = 0;
    for(int i = 0; i < num1; ++i) 
        nums[num0 + i] = 1;
    for(int i = 0; i < num2; ++i) 
        nums[num0 + num1 + i] = 2;
}
