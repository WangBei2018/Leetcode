package Sort;

import java.awt.geom.PathIterator;

/**
 * @Author WangBei
 * @Date 2021/6/23 16:13
 * @Description:快速排序，升序
 */
public class quickSort {

    int[] seq;

    quickSort(int[] seq) {
        this.seq = seq;
    }

    public void QuickSort(int[] seq, int length, int start, int end) {
        if (start == end) return;
        int index = Partition(seq, length, start, end);         // 通过选择的数字将数组分为两部分
        if (index > start) QuickSort(seq, length, start, index - 1);
        if (index < end) QuickSort(seq, length, index + 1, end);
    }

    public int Partition(int[] seq, int length, int start, int end) {
        if (seq == null || length <= 0 || start < 0 || end >= length) {
            return -1;
        }
        int num = seq[start];
        while (start < end) {
            if (seq[end] < seq[start] && seq[start] == num) {
                int t = seq[start];
                seq[start] = seq[end];
                seq[end] = t;
                start++;
            } else if (seq[end] < seq[start] && seq[end] == num) {
                int t = seq[start];
                seq[start] = seq[end];
                seq[end] = t;
                end--;
            } else if (seq[start] == num) {
                end--;
            } else {
                start++;
            }
        }
        return start;
    }
}
