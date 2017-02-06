class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        unordered_set<int> hs;
        for (int i = 0; i < nums.size(); i++) {
            if (hs.size() > k) {
                //attention!!! i - k - 1 !
                hs.erase(nums[i-k-1]);
            }
            if (hs.find(nums[i]) != hs.end()) {
                return true;
            }
            hs.insert(nums[i]);
        }
        return false;
    }
};
