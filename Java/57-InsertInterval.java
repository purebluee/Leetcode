/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 /*
 Since the problem can be divided by two steps, insert and merge, we can do it step by step. Insertion is very simple, we just need to scan the input intervals and compare the start value until we found one is larger than the insert interval. Then we insert the token into the ArrayList. The merge process will be exactly the same as the Merge Interval problem. 
 */
 
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
         
        // check if the list is empty or null
        if (intervals == null || newInterval == null) return result;
         
        if (intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }
         
        // find the insertion point and insert the new newInterval
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start > newInterval.start) {
                intervals.add(i, newInterval);
                break;
            }
        }
        // insert at end of the list
        intervals.add(newInterval);
         
        // merge the overlapped intervals
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (isOverlapped(prev, curr)) {
                Interval temp = new Interval();
                temp.start = prev.start;
                temp.end = Math.max(prev.end, curr.end);
                prev = temp;
            } else {
                result.add(prev);
                prev = curr;
            }
        }
        result.add(prev);
         
        return result;
    }
     
    private boolean isOverlapped(Interval prev, Interval curr) {
        return curr.start <= prev.end;        
    }
}

/*
A Better Solution:
Does there exist a better solution without needing to modify the input parameters? The answer is yes. Re-think the question. 
We are not actually required to insert an interval into the original. We are only asked to return the final merged list. 

Following this idea, we could decide when we insert an internal, what needs to be inserted into the result list. There are three cases:
1. For the current interval is less than the newInterval, i.e, the end of current interval is less than the start of newInterval. 
Then there must have no overlapping. In this case, we only need to insert the current interval into the result list. 
2. For the current interval is greater than the newInterval. That is, the start of the current interval is greater than the end of newInterval. 
In this case, we insert the newInterval into the result list, and update the newInterval as current interval. 
3. For other cases where we have overlapped regions. We merge the two intervals and update the newInterval. 
*/
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
         
        if (newInterval == null) return intervals;
         
        if (intervals == null || intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
         
        Interval prev = newInterval;
         
        for (Interval curr : intervals) {
            // if curr interval is greater than prev
            if (curr.start > prev.end) {
                result.add(prev);
                prev = curr;
            } else if (curr.end < prev.start) {
                result.add(curr);
            } else {
                prev.start = Math.min(prev.start, curr.start);
                prev.end = Math.max(prev.end, curr.end);
            }
        }
        result.add(prev);
        return result;
    }
}