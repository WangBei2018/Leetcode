package NC88_FindKth;

/**
 * @Author WangBei
 * @Date 2021/7/22 15:23
 * @Description:
 */
public class Solution {
    int[] a;

    public int findKth(int[] a, int n, int K) {
        // write code here
        this.a = a;
        quickSort(a, 0, n - 1);
        return a[K - 1];
    }

    public void quickSort(int[] a, int start, int end) {
        if (start == end) return;
        int index = partition(a, start, end);
        if (index > start) quickSort(a, start, index - 1);
        if (index < end) quickSort(a, index + 1, end);
    }

    public int partition(int[] a, int start, int end) {
        if (a == null || a.length == 0 || start < 0 || end > a.length - 1) return -1;
        int num = a[start];
        while (start < end) {
            if (a[start] < a[end] && a[start] == num) {
                int t = a[start];
                a[start] = a[end];
                a[end] = t;
                start++;
            } else if (a[start] < a[end] && a[end] == num) {
                int t = a[start];
                a[start] = a[end];
                a[end] = t;
                end--;
            } else if (a[start] == num) {
                end--;
            } else {
                start++;
            }
        }
        return start;
    }
}