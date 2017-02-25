/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
 //Given [1,2],[3,5],[6,7],[8,10],[12,16],
 //insert and merge [4,9] in as [1,2],[3,10],[12,16]
class Solution {
public:
    vector<Interval> insert(vector<Interval>& intervals, Interval newInterval) {
        vector<Interval> res;
        if (intervals.empty()) {
            res.push_back(newInterval);
            return res;
        }
        int start = newInterval.start;
        int end = newInterval.end;
        int i = 0;
        while (i < intervals.size() && intervals[i].end < newInterval.start) {
            res.push_back(intervals[i]);
            i++;
        }
        while (i < intervals.size() && intervals[i].start <= newInterval.end) {
            start = min(intervals[i].start, start);
            end = max(intervals[i].end, end);
            i++;
        }
        res.push_back(Interval(start, end));
        while (i < intervals.size()){
            res.push_back(intervals[i]);
            i++;
        }
        return res;
    }
};
