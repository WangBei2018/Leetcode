package Leetcode56_Merge;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WangBei
 * @Date 2021/7/22 13:50
 * @Description:
 */
public class Solution {
    int[][] intervals;


    public int[][] merge(int[][] intervals) {
        this.intervals = intervals;
        if (intervals.length == 1) return intervals;
        quickSort(intervals, 0, intervals.length - 1);
        List<List<Integer>> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<Integer> array = new ArrayList<>();
        array.add(intervals[0][0]);
        array.add(intervals[0][1]);
        list.add(array);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= start) {         // 大于当前最右边区间的起点
                if (intervals[i][0] <= end) {       // 并且小于最有区间的终点
                    if (intervals[i][1] > end) {    // 有交叉，那么原始的区间的终点修改为新加入区间的右端点
                        end = intervals[i][1];
                    }
                    array = new ArrayList<>();
                    array.add(start);
                    array.add(end);
                    list.set(list.size() - 1, array);
                } else {                            // 没有交叉的部分，直接修改当前待合并区间的起点终点，并将其添加到最终的数组中
                    start = intervals[i][0];
                    end = intervals[i][1];

                    array = new ArrayList<>();
                    array.add(start);
                    array.add(end);
                    list.add(array);
                }
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> row = list.get(i);
            res[i][0] = row.get(0);
            res[i][1] = row.get(1);
        }
        return res;
    }

    public void quickSort(int[][] intervals, int start, int end) {
        if (start == end) return;
        int index = partition(intervals, start, end);
        if (index > start) quickSort(intervals, start, index - 1);
        if (index < end) quickSort(intervals, index + 1, end);
    }

    public int partition(int[][] seq, int start, int end) {
        if (seq == null || seq.length == 0 || start < 0 || end > seq.length) {
            return -1;
        }
        int num = seq[start][0];
        while (start < end) {
            if (seq[start][0] > seq[end][0] && seq[start][0] == num) {
                int[] t = seq[start];
                seq[start] = seq[end];
                seq[end] = t;
                start++;
            } else if (seq[start][0] > seq[end][0] && seq[end][0] == num) {
                int[] t = seq[start];
                seq[start] = seq[end];
                seq[end] = t;
                end--;
            } else if (seq[start][0] == num) {
                end--;
            } else {
                start++;
            }
        }
        return start;
    }
}
