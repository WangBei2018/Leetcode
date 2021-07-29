package NC119_GetLeastNumbers_Solution;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Author WangBei
 * @Date 2021/7/24 14:12
 * @Description: NC119 最小的K个数 ---- offer40
 * 描述
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 0 <= k <= input.length <= 10000
 * 0 <= input[i] <= 10000
 *
 * 示例1
 * 输入：[4,5,1,6,2,7,3,8],4
 * 返回值：[1,2,3,4]
 * 说明：返回最小的4个数即可，返回[1,3,2,4]也可以
 *
 * 示例2
 * 输入： [1],0
 * 返回值：[]
 *
 * 示例3
 * 输入：[0,1,2,1,2],3
 * 返回值：[0,1,1]
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || k == 0) return null;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x1, x2) -> Integer.compare(x2, x1));
        for (int num : input) {
            if (pq.size() >= k) {
                if (num < pq.peek()) {
                    pq.poll();
                    pq.offer(num);
                }
            } else {
                pq.offer(num);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : pq) {
            list.add(num);
        }
        return list;
    }
}
/** 思路：优先队列（堆排序，大根堆）
 *  1. 使用优先队列（默认是小根堆），所以使用 Comparetor 比较器，将其变为大根堆
 *  2. 遍历 input 数组中的数字，当堆的大小 >= k 时，当前 k 个值是当前加入的所有的数中最小的 k 个，
 *     所以在这之后每次有新的数加入的时候，只需当前数字小于堆顶元素时，将堆顶数字出堆，并将当前数字加入堆
 *  3. 当前堆中的大小小于 k 时，直接入堆。
 *
 * 堆排序中：
 * ···大根堆：实现升序
 * ···小根堆：实现降序
 * */