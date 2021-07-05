package offer04_FindNumberIn2DArray;

/**
 * @Author WangBei
 * @Date 2021/6/9 8:44
 */

/*
    从右上角开始查找：（也可从左下角开始，其余两个角不可以，可以参照实例分析）
        当前数字等于target，则查找结束;
        当前数字大于target，删除当前数字所在列，column--;
            因为当前数字已经大于target，他下面的数字都大于当前数字，则肯定大于target。
        当前数字小于target，删除当前数字所在行，row++;
*/

public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean found = false;

        if (matrix.length != 0) {
            int row = 0, column = matrix[0].length - 1;     // 从matrix右上角开始查找
            while (row < matrix.length && column >= 0) {
                if (matrix[row][column] == target) {        // 当前数字等于target，则查找结束
                    found = true;
                    break;
                } else if (matrix[row][column] > target) {  // 当前数字大于target，删除当前数字所在列，column--
                    column--;
                } else if (matrix[row][column] < target) {  // 当前数字小于target，删除当前数字所在行，row++;
                    row++;
                }
            }
        }
        return found;
    }
}
