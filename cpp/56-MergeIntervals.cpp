/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */

 //Given [1,3],[2,6],[8,10],[15,18],
 //return [1,6],[8,10],[15,18].
class Solution {
public:
    vector<Interval> merge(vector<Interval>& intervals) {
        vector<Interval> res;
        if (intervals.size() == 0)
            return res;
        sort(intervals.begin(), intervals.end(), [](Interval i1, Interval i2){
            return i1.start - i2.start < 0;
        });
        int start = intervals[0].start, end = intervals[0].end;
        for (int i = 1; i < intervals.size(); i++) {
            //attention to the condition below
            if (intervals[i].start - end < 1) {
                end = max(end, intervals[i].end);
            } else {
                res.push_back(Interval(start, end));
                start = intervals[i].start;
                end = intervals[i].end;
            }
        }
        //Don't forget!!!!
        res.push_back(Interval(start, end));
        return res;
    }
};
