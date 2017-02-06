class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int res = 0, len = nums.size();
        for (int i = 0; i < len; i++) {
            res ^= nums[i];
            res ^= i;
        }
        return res ^ len;
    }
};

//binary search
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int start = 0, end = nums.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
};
