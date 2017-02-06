class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int dpmax[nums.size() + 1] = {};
        int dpmin[nums.size() + 1] = {};
        dpmax[0] = nums[0];
        dpmin[0] = nums[0];
        int maxP = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            dpmax[i] = max(dpmin[i-1] * nums[i], max(nums[i], dpmax[i-1] * nums[i]));
            dpmin[i] = min(dpmin[i-1] * nums[i], min(nums[i], dpmax[i-1] * nums[i]));
            maxP = max(maxP, dpmax[i]);
        }
        return maxP;
    }
};

//need to think: without dp arrays
class Solution {
public:
    int maxProduct(vector<int>& nums) {
        // store the result that is the max we have found so far
        int r = nums[0];

        // imax/imin stores the max/min product of
        // subarray that ends with the current number nums[i]
        for (int i = 1, imax = r, imin = r; i < nums.size(); i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (nums[i] < 0)
                swap(imax, imin);

            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = max(nums[i], imax * nums[i]);
            imin = min(nums[i], imin * nums[i]);

            // the newly computed max value is a candidate for our global result
            r = max(r, imax);
        }
        return r;
    }
};
