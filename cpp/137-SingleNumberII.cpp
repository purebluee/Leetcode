class Solution {
public:
    int singleNumber(vector<int>& nums) {
        const int W = sizeof(int) * 8;//number of bits in int
        vector<int> count(W); //count[i] represents number of 1s appeared.
        for (int i = 0; i < nums.size(); i++){
            for (int j = 0; j < W; j++){
                count[j] += (nums[i] >> j) & 1;
                count[j] %= 3;
            }
        }
        int res = 0;
        for (int i = 0; i < W; i++){
            res += (count[i] << i);
        }
        return res;
    }
};
