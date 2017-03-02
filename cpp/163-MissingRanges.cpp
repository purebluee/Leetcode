class Solution {
public:
    vector<string> findMissingRanges(vector<int>& nums, int lower, int upper) {
        vector<string> res;
        if (nums.size() == 0) {
            if (lower != upper)
                res.push_back(std::to_string(lower) + "->" + std::to_string(upper));
            else
                res.push_back(std::to_string(lower));
            return
                res;
        }
        int front = lower;
        int i = 0;
        for (i = 0; i < nums.size(); i++) {
            if (nums[i] > upper) {
                res.push_back(std::to_string(lower) + "->" + std::to_string(upper));
                break;
            }
            if (nums[i] == upper) {
                if (lower != upper) {
                    if (lower == upper - 1)
                        res.push_back(std::to_string(lower));
                    else
                        res.push_back(std::to_string(lower) + "->" + std::to_string(upper-1));
                }
                break;
            }
            if (nums[i] < lower)
                continue;
            if (nums[i] == lower) {
                lower++; continue;
            }
            if (nums[i] - 1 == lower) {
                res.push_back(std::to_string(lower));
            }
            else {
                res.push_back(std::to_string(lower) + "->" + std::to_string(nums[i]-1));
            }
            lower = nums[i] + 1;
        }
        if (i == nums.size()) {
            if (upper == nums[i-1] + 1)
                res.push_back(std::to_string(upper));
            else
                res.push_back(std::to_string(nums[i-1] + 1) + "->" + std::to_string(upper));
        }
        return res;
    }
};

//short version
class Solution {
public:
    string get_range(int start, int end)
    {
        return start==end? to_string(start) : to_string(start)+"->"+to_string(end);
    }
    vector<string> findMissingRanges(vector<int>& nums, int lower, int upper) {
        vector<string> result;
        int pre = lower-1;
        for(int i =0; i <= nums.size(); i++)
        {
           int cur = (i==nums.size()? upper+1:nums[i]);
           if(cur-pre>=2)
            result.push_back(get_range(pre+1,cur-1));
            pre = cur;
        }
        return result;
    }
};
