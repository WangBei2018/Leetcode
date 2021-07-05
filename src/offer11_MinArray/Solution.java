package offer11_MinArray;

/**
 * @Author WangBei
 * @Date 2021/6/25 11:10
 * @Description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 */

// 其实就是求最小值，但是利用本题给出的旋转数组的条件，可以进行二分查找，而不是使用遍历一次整个数组，这样时间复杂度太高
class Solution {
    public int minArray(int[] numbers) {

        if (numbers == null || numbers.length <= 0) {
            return -1;
        }

        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            if (numbers[mid] > numbers[end]) {              // 不要和numbers[start]比，因为如果数组本来就有序时，会跳过最小的数，例如：{3,4,5}
                start = mid + 1;
            } else if (numbers[mid] < numbers[end]) {
                end = mid;
            } else {                        // start==end，此时不能判断最小数字在那半段，例如：{1,0,1,1,1},{1,1,1,0,1},所以只能通过end--来缩小搜索范围
                end--;
            }
        }
        return numbers[start];
    }
}
