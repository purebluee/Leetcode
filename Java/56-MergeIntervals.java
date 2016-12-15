/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0){
            return res;
        }
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++){
            Interval curr = intervals.get(i);
            if (curr.start <= prev.end){
                //prev.start = prev.start;
                prev.end = Math.max(curr.end, prev.end);
            }else{
                res.add(prev);
                prev = curr;
            }
        }
        res.add(prev);
        return res;
    }
}