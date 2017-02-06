//An assumption is the frequency of majority element > n/2
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (count == 0) {
                count++;
                major = nums[i];
            }else if (major == nums[i]) {
                count++;
            }else
                count--;
        }
        return major;
    }
};

//hashmap solution. Easy to understand
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        unordered_map<int, int> hm;
        for (int i = 0; i < nums.size(); i++) {
            if (hm.find(nums[i]) == hm.end())
                hm[nums[i]] = 1;
            else
                hm[nums[i]]++;
        }
        for (auto n : hm) {
            if (n.second > nums.size() / 2)
                return n.first;
        }
        return -1;
    }
};
