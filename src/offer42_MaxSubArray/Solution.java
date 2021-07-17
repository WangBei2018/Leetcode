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
    // 超出时间限制
//    public int maxSubArray(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        int maxValue = nums[0];
//        for (int i = 0; i < nums.length - 1; i++) {
//            int sum = nums[i];
//            maxValue = Math.max(maxValue, sum);
//            for (int j = i + 1; j < nums.length; j++) {
//                sum += nums[j];
//                maxValue = Math.max(maxValue, sum);
//            }
//        }
//        return Math.max(maxValue, nums[nums.length - 1]);
//    }

    // 动态规划：dp[i]表示以nums[i]为结尾的子数组之和最大值（满足连续性）
    // dp[i] = nums[i]              , nums[i] > dp[i-1] + nums[i]
    //       = nums[i-1] + nums[i]  , nums[i] < dp[i-1] + nums[i]
    // 直接在原数组上改变当前nums[i]结尾的最大子数组之和，也可以将nums[i-1]和nums[i]的值存起来，这样就不用改变原数组
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxSum = nums[0];

//        // 方式一：直接在原始数组上进行修改当前最大值
//        for (int i = 1; i < nums.length; i++) {
//            nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
//            maxSum = Math.max(maxSum, nums[i]);
//        }
//        return maxSum;

        // 方式二：使用两个额外的变量，记录最大值，以及当前那计算结果
        int dp_i_1 = nums[0];
        int dp_i = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp_i = Math.max(dp_i_1 + nums[i], nums[i]);
            dp_i_1 = dp_i;
            maxSum = Math.max(maxSum, dp_i);
        }
        return maxSum;
    }
}
/**
 * 思路：
 * 1. 直接在原数组上进行修改，当前最大子数组之和 maxSum 初始化为 nums[0]
 * 2. nums[i]存放，到第 i 个数字为止，当前最大的数组之和，即如果前i-1个数组之和的最大值大于0，则当前位置的数加上之前的最大和为最新的最大值，否则，不加之前的最大和
 * 3. 最后nums数组中的最大值便是整个数组中最大的子序列之和。
 */
