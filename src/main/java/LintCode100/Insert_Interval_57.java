package LintCode100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-01 11:43
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 **/
public class Insert_Interval_57 {

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList();
        if(intervals.size() == 0 || intervals == null){
            list.add(newInterval);
            return list;
        }
        //从小到大排序
        intervals.add(newInterval);
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b)
            {
                return a.start - b.start;
            }
        });

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



