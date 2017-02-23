//4 5 6 7 8 9 0 1 2 3
//6 7 8 9 0 1 2 3 4 5

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int start = 0, len = nums.size(), end = len - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] <= nums[end]) {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
};
