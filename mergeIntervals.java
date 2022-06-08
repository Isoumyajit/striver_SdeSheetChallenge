import java.util.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

class Interval {
    int start, finish;

    Interval(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

public class mergeIntervals {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        // write your code here.
        List<Interval> answer = new ArrayList<>();
        int len = intervals.length;
        if (len == 1) {
            answer.add(intervals[0]);
            return answer;
        }
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        int start = intervals[0].start;
        int end = intervals[0].finish;
        for (int index = 1; index < len; index++) {
            if (end >= intervals[index].start) {
                end = Math.max(end, intervals[index].finish);
            } else {
                Interval dummy = new Interval(start, end);
                answer.add(dummy);
                start = intervals[index].start;
                end = intervals[index].finish;
            }
        }
        Interval dummy = new Interval(start, end);
        answer.add(dummy);
        // System.out.println(answer);
        return answer;
    }
}
