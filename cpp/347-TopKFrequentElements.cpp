//max heap
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> umap;
        for (int i = 0; i < nums.size(); i++) {
            if (umap.find(nums[i]) == umap.end()) {
                umap[nums[i]] = 1;
            } else {
                umap[nums[i]]++;
            }
        }
        vector<int> res;
        priority_queue<pair<int, int>> pq;
        for (auto item : umap) {
            //pair order flipped here
            pq.push(make_pair(item.second, item.first));
            if (pq.size() > umap.size() - k) {
                res.push_back(pq.top().second);
                pq.pop();
            }
        }
        return res;
    }
};

//min heap
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> umap;
        for (int num : nums) {
            if (umap.find(num) == umap.end()) {
                umap[num] = 1;
            } else {
                umap[num]++;
            }
        }
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        vector<int> res;
/*
with iterator:
        for (auto it = umap.begin(); it != umap.end(); it++) {
            pq.push(make_pair(it->second, it->first));
            while (pq.size() > k)
                pq.pop();
        }
*/
        for (auto item : umap) {
            pq.push(make_pair(item.second, item.first));
            while (pq.size() > k)
                pq.pop();
        }
        while (!pq.empty()) {
            res.push_back(pq.top().second);
            pq.pop();
        }
        return res;
    }
};
