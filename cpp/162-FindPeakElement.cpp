//[1, 2, 3, 1]
//sequencial search
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        for (int i = 0; i < nums.size(); i++) {
            if (i != 0 && nums[i] < nums[i-1])
                return i - 1;
        }
        return nums.size() - 1;
    }
};

//binary search
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int res = -1;
        int start = 0, end = nums.size() - 1;
        while (start < end) {
            int mid = start + ((end - start) >> 1);
            int mid2 = mid + 1;
            if (mid != 0 && nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            } else if (nums[mid2] > nums[mid]) {
                start = mid2;
            } else if (nums[mid2] < nums[mid]) {
                end = mid;
            }
        }
        return nums[start] > nums[end] ? start : end;
    }
};
