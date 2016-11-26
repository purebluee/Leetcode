/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
//use comparator
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0){
            return true;
        }
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i].start - intervals[i-1].end < 0){
                return false;
            }
        }
        return true;
    }
}


//define comparator in a separate class
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0){
            return true;
        }
        
        //sort the intervals by start time
        Arrays.sort(intervals, new IntervalComparator());
        
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i].start < intervals[i-1].end){
                return false;
            }
        }
        return true;
    }
    
    public class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }
    }
}



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
 public class Interval{
     int start;
     int end;
     Inverval(){
         start = 0; end = 0;
     }
     Interval(int s, int e){
         start = s;
         end = e;
     }
 }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        int len = intervals.length;
        if (len == 0 || intervals == null)
            return true;
        int[] begin = new int[len];
        int[] end = new int[len];
        for (int i = 0; i < len; i++){
            begin[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(begin);
        Arrays.sort(end);
        for (int i = 1; i < len; i++){
            if (begin[i] < end[i-1]){
                return false;
            }
        }
        return true;
    }
}