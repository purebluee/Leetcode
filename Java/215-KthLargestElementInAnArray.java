/*
A min-heap solution:
 -- Step 1: put the first k elements into the heap. Time complexity is O(k). 
 -- Step 2: Start from elements k + 1 to n, compare each one with heap.peek(). If greater than the peek, replace with the element. The time complexity is O((n - k) logk).
  -- Step 3: After we iterate the array, the heap stores the top k elements, and the kth largest element is the minimum element of the heap, which is peek.

The space complexity is O(k). 
*/
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
         
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k);
         
        for (int num : nums) {
            if (maxHeap.size() < k) {
                maxHeap.offer(num);
            } else {
                if (num > maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.offer(num);
                }
            }
        }
         
        return maxHeap.peek();
    }
}

/*
A quick-selection algorithm:
The quick selection algorithm is very similar to quick sort. 
Instead of sorting, it only needs the partition step, where it finds the pivot and compare the pivot with k. 
*/
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1, index = nums.length - k;
        while (start < end) {
            int pivot = partion(nums, start, end);
            if (pivot < index){
                start = pivot + 1;  
            }else if (pivot > index) {
                end = pivot - 1;
            }else {
                return nums[pivot];
            }
        }
        return nums[start];
    }
    
    private int partion(int[] nums, int start, int end) {
        int pivot = start;
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot]) {
                start++;
            }
            while (start <= end && nums[end] > nums[pivot]) {
                end--;
            }
            if (start > end) {
                break;
            }
            swap(nums, start, end);
        }
        swap(nums, pivot, end);
        return end;
    }

    private void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}