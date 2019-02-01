package LintCode100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-01-21 13:43
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 **/



public class Merge_Intervals_56 {

    private static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0 || intervals == null){
            return intervals;
        }
        //从小到大排序
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b)
            {
                return a.start - b.start;
            }
        });
        List<Interval> list = new ArrayList();
        Interval temp = intervals.get(0);
        for(int i = 1;i<intervals.size();i++){
            Interval interval = intervals.get(i);
            if(temp.start >= interval.start){
                temp.start = Math.min(temp.start,interval.start);
            }
            if(temp.end >= interval.start){
                temp.end = Math.max(temp.end,interval.end);
            }else{
                list.add(temp);
                temp = interval;
            }

        }
        list.add(temp);
        return list;
    }
}



