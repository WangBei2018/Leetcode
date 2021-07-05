package offer63_MaxProfit;

/**
 * @Author WangBei
 * @Date 2021/6/30 15:18
 * @Description:题目：假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？ 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * <p>
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 限制：
 * 0 <= 数组长度 <= 10^5
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int minPrice = prices[0];
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);                   // 找到整个价格序列中最小的价格，遍历过程中计算这个最小价格和后面价格的差值
            profit = Math.max(price - minPrice, profit);            // 比较当前最大利润与当前价格与最低价的差值的大小，计算最大利润
        }
        return profit;
    }
}
