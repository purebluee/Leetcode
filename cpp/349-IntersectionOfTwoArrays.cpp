class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        vector<int> res;
        unordered_set<int> hs(nums1.begin(), nums1.end());
        for (auto num : nums2) {
            if (hs.count(num) != 0) {
                res.push_back(num);
                hs.erase(num);
            }
        }
        return res;
    }
};
