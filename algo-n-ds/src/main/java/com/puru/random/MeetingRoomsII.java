package com.puru.random;

import java.util.Arrays;
import java.util.PriorityQueue;
public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals==null || intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, (intVal1, intVal2)->intVal1.start-intVal2.start);
        PriorityQueue<Interval> pq = new PriorityQueue<>((intVal1,intVal2)->intVal1.end-intVal2.end);
        pq.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            Interval prev = pq.poll();
            Interval curr = intervals[i];
            if(curr.start<prev.end){
                pq.add(curr);
            }else{
                prev.end = curr.end;
            }
            pq.offer(prev);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(0,30);
        intervals[1] = new Interval(5,10);
        intervals[2] = new Interval(15,20);
        int rooms = new MeetingRoomsII().minMeetingRooms(intervals);
        System.out.println("rooms-->"+rooms);
    }
}
class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }
