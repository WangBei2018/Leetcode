package ZJ_MaxK;

import java.util.HashMap;

/**
 * @Author WangBei
 * @Date 2021/7/23 15:26
 * @Description: 找到数组中出现次数最多的第一个元素的下标
 */
public class Solution {
    public int MaxK(int[] arr) {
        int index = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        int maxTimes = 0;
        for (int num : arr) {
            hm.put(num, hm.getOrDefault(num, 1) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (hm.get(arr[i]) > maxTimes) {
                maxTimes = hm.get(arr[i]);
                index = i;
            }
        }
        return index;
    }
}
