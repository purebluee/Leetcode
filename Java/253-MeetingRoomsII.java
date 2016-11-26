/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
//Updated Nov 25-2016
//Sorting two arrays take O(nlogn) time. Compare takes O(n) time. So the overall time complexity is still bounded by O(nlogn). 
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0){
            return 0;
        }
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        for (int i = 0; i < len; i++){
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int numRooms = 0;
        int activeMeetings = 0;
        int i = 0;
        int j = 0;
        while (i < len && j < len){
            if (starts[i] < ends[j]){
                activeMeetings++;
                numRooms = Math.max(numRooms, activeMeetings);
                i++;
            }else{
                activeMeetings--;
                j++;
            }
        }
        return numRooms;
    }
}

//priority queue solution
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0].end);
        int numRooms = 1;
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i].start < pq.peek()){
                pq.offer(intervals[i].end);
                numRooms++;
            }else{
                pq.poll();
                pq.offer(intervals[i].end);
            }
        }
        return numRooms;
    }
}

//
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