class Solution {
public:
    int threeSumSmaller(vector<int>& nums, int target) {
        int res = 0;
        if (nums.size() < 3)
            return 0;
        sort(nums.begin(), nums.end());
        int len = nums.size();
        int i = 0, j = 1, k = len - 1;
        for (; i < len - 2; i++) {
            j = i + 1;
            k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < target) {
                    res += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
};

//editorial Solution
class Solution {
public:
    int threeSumSmaller(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int sum = 0;
        for (int i = 0; i < nums.size() - 2; i++) {
            sum += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return sum;
    }

    int twoSumSmaller(vector<int>& nums, int startIndex, int target) {
        int sum = 0;
        int left = startIndex;
        int right = nums.size() - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                sum += right - left;
                left++;
            } else {
                right--;
            }
        }
        return sum;
    }
};
