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
    public int minMeetingRooms(Interval[] intervals) {
        int len = intervals.length;
        int[] begin = new int[len], end = new int[len];
        for (int i = 0; i < len; i++){
            begin[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(begin);
        Arrays.sort(end);
        int rooms = 0, ended = 0;
        for (int i = 0; i < len; i++){
            if (begin[i] < end[ended]){
                rooms ++;
            }else{
                ended ++;
            }
        }
        return rooms;
    }
}