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