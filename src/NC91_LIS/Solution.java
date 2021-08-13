package NC91_LIS;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WangBei
 * @Date 2021/8/11 17:04
 * @Description: NC91 最长递增子序列
 * 描述: 给定数组arr，设长度为n，输出arr的最长递增子序列。（如果有多个答案，请输出其中 按数值(注：区别于按单个字符的ASCII码值)进行比较的 字典序最小的那个）
 * <p>
 * 示例1
 * 输入：[2,1,5,3,6,4,8,9,7]
 * 返回值：[1,3,4,8,9]
 * <p>
 * 示例2
 * 输入：[1,2,8,6,4]
 * 返回值：[1,2,4]
 * <p>
 * 说明：其最长递增子序列有3个，（1，2，8）、（1，2，6）、（1，2，4）其中第三个 按数值进行比较的字典序 最小，故答案为（1，2，4）
 * <p>
 * 备注：
 * n ≤ 10^5
 * 1 ≤ arr_i≤10^9
 */
public class Solution {
    /**
     * retrun the longest increasing subsequence
     *
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public int[] LIS(int[] arr) {
        // write code here

        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        if (arr.length == 1) {
            return arr;
        }

        List<Integer> res = new ArrayList<>();

        int i;
        for (i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                res.add(arr[i - 1]);
                break;
            }
        }

        int k;
        for (int j = i; j < arr.length; j++) {
            int flag = 0;
            for (k = j + 1; k < arr.length; k++) {
                if (arr[k] < arr[k - 1]) {
                    if (arr[k] < res.get(res.size() - 1)) {
                        res.add(arr[k - 1]);
                        flag = 1;
                    }
                    continue;
                } else {
                    break;
                }
            }
            if (flag == 0) {
                res.add(arr[k - 1]);
            }

            if (j + 1 == k) {
                res.add(arr[k]);
            }
            j = k;
        }
        int[] subArr = new int[res.size()];
        for (i = 0; i < subArr.length; i++) {
            subArr[i] = res.get(i);
        }
        return subArr;
    }
}
