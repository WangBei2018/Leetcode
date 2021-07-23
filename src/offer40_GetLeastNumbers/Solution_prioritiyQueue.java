package offer40_GetLeastNumbers;

import java.util.PriorityQueue;

/**
 * @Author WangBei
 * @Date 2021/7/23 10:13
 * @Description:
 */
public class Solution_prioritiyQueue {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0) return new int[0];
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        PriorityQueue<Integer> heap = new PriorityQueue<>((x1, x2) -> Integer.compare(x2, x1)); //Compare比较器
        for (int num : arr) {
            if (heap.size() < k) {
                heap.offer(num);
            } else if (num < heap.peek()) {
                heap.poll();
                heap.offer(num);
            }
        }
        int[] res = new int[k];
        int idx = 0;
        for (int num : heap) {
            res[idx++] = num;
        }
        return res;
    }
}
/**
 * 思路：大根堆------保证让堆中的元素个数不超过 k ，
 * ···1. 当前堆中的元素小于 k 时，直接元素进堆
 * ···2. 当前堆中元素大于等于 k 时，判断元素与堆顶元素大小，小于则堆顶元素出堆，当前元素入堆。否则丢弃当前元素。
 * 大根堆解决升序，小根堆解决降序。
 */