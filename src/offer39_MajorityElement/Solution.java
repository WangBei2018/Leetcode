package offer39_MajorityElement;

/**
 * @Author WangBei
 * @Date 2021/7/23 15:26
 * @Description: 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * <p>
 * 限制：
 * 1 <= 数组长度 <= 50000
 * <p>
 * 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int cur = nums[0];
        int sum = 1;
        for (int i = 1; i < nums.length; i++) {
            if (sum == 0) {
                cur = nums[i];
            }
            if (nums[i] != cur) {
                sum--;
            } else {
                sum++;
            }
        }
        return cur;
    }
}
/**
 * 思路：摩尔投票法
 * 首先将数组第一个数字为基准记为 +1 ，向后遍历数组，相同则 +1 ，不同则 -1 。
 * 当和 = 0 时，重新以数组下一个数为基准进行加减操作，
 * 直到遍历完整个数组，和不为0，则返回此时的基准数字
 * 例： 1, 2, 3, 2, 2, 2, 5, 4, 2
 *     +1 -1
 *     1, 2, 3, 2, 2, 2, 5, 4, 2
 *           +1 -1
 *     1, 2, 3, 2, 2, 2, 5, 4, 2
 *                 +1 +1 -1 -1
 *     1, 2, 3, 2, 2, 2, 5, 4, 2
 *                             +1
 * 所以超过一半的数为 2 。
 */