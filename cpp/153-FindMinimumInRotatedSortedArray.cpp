//3 4 5 6 0 1 2
class Solution {
public:
    int findMin(vector<int>& nums) {
        if (nums.size() == 1)
            return nums[0];
        int start = 0, len = nums.size(), end = len - 1;
        if (nums[0] < nums[end])
            return nums[0];
        while (start <= end) {
            int mid = start + ((end - start) >> 2);
            //cout << mid << endl;
            if (mid != 0 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            } else if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
};
