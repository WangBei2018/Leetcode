package offer42_MaxSubArray;

/**
 * @Author WangBei
 * @Date 2021/6/30 16:09
 * @Description:输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 要求时间复杂度为O(n)。
 * <p>
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 * <p>
 * 提示：
 * 1 <=arr.length <= 10^5
 * -100 <= arr[i] <= 100
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxValue = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i];
            maxValue = Math.max(maxValue, sum);
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                maxValue = Math.max(maxValue, sum);
            }
        }
        return Math.max(maxValue, nums[nums.length - 1]);
    }
}
