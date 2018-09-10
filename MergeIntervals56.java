import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
/**
 * 题意：把重叠区间给算出来
 * 收获：1、comparator类 实现compare方法，List均可实现比较
        2、判断重叠区的逻辑
        3、细节，如right = r>right?r:right; 考虑(1,4) (2,3) 这种情况，即后者的end不一定大于前者的end、无论如何返回一个List，不能返回null，会报错，也要注意判断输入为空和长度为0的情况
        4、击败了56.05%
        */

public class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
}
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        if(intervals==null||intervals.size()==0)
            return ans;
        List<Interval> input = intervals;
        input.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1,Interval o2){
                if(o1.start<o2.start)
                    return -1;
                else if (o1.start>o2.start)
                    return 1;
                else if (o1.start==o2.start&&o1.end<o2.end)
                    return -1;
                else if (o1.start==o2.start&&o1.end>o2.end)
                    return 1;
                else return 0;
            }
        });
        
        int left = input.get(0).start;
        int right = input.get(0).end;
        for(int i=0;i<input.size();i++){
            int l = input.get(i).start;
            int r = input.get(i).end;
            if(l>=left&&l<=right){
                right = r>right?r:right;
            }else{
                Interval node = new Interval(left,right);
                ans.add(node);
                left = input.get(i).start;
                right = input.get(i).end;
            }
            if(i==input.size()-1){
                Interval node = new Interval(left,right);
                ans.add(node);
            }
        }
        return ans;
    }
}
}