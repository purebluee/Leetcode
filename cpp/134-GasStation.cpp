class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        if (gas.empty() || cost.empty())
            return 0;
        if (gas.size() == 1) {
            return gas[0] >= cost[0] ? 0 : -1;
        }
        int currSum = 0, totalSum = 0, start = 0;
        for (int i = 0; i < gas.size(); i++) {
            currSum += gas[i];
            currSum -= cost[i];
            totalSum += gas[i];
            totalSum -= cost[i];
            if (currSum < 0) {
                start = i + 1;
                currSum = 0;
            }
        }
        return totalSum < 0 ? -1 : start;
    }
};
