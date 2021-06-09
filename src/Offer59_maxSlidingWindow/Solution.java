package Offer59_maxSlidingWindow;

import java.util.*;


/*
滑动窗口的最大值

给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

 */

class Solution {
//    Queue<Integer> queue;
    Deque<Integer> deque;

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];             // 边界：当输入的数组为空时
//        queue = new LinkedList<>();                       // 存放滑动窗口的内容
        deque = new LinkedList<>();                         // 存放最大值
        int[] list = new int[nums.length - k + 1];          // 存放结果

        for (int i = 0; i < k; i++) {                       // 还没有达到窗口长度时，只讲当前元素进队，以及更新最大元素的双端队列
//            queue.offer(nums[i]);
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
        }

        int maxValue = maxQueue(nums[0]);                               // 刚好形成第一个窗口时，计算当前窗口中的最大值
        int j = 0;                                                      // 记录结果数组的下标
        list[j] = maxValue;

        for (int i = k ; i < nums.length; i++) {                        // 窗口向后滑动
//            queue.offer(nums[i]);                                     // 1.元素入队
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {    // 2.更新最大元素的双端队列
                deque.pollLast();
            }
            deque.offerLast(nums[i]);                                   // 3.将当前值加入到双端队列中比他小的丢一个元素之后
            maxValue = maxQueue(nums[i-k]);                             // 4.计算当前滑动窗口中的最大值
            j++;
            list[j] = maxValue;
        }
        return list;
    }


    public int maxQueue(int value) {                // 返回当前滑动窗口中的最大值
        int maxValue = deque.peekFirst();
//        int value = queue.poll();                 // 执行下一个滑动窗口的出队操作
        if (value == maxValue) {
            deque.pollFirst();                      // 当队列中的出队元素等于滑动窗口的最大值时，双端队列中的最大值也出队
        }
        return maxValue;
    }


}
