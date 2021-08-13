package NC108_MaxArea;

/**
 * @Author WangBei
 * @Date 2021/8/11 15:51
 * @Description: NC108 最大正方形
 * 描述: 给定一个由'0'和'1'组成的2维矩阵，返回该矩阵中最大的由'1'组成的正方形的面积
 *
 * 示例1
 * 输入：[[1,0,1,0,0],[1,0,1,1,1],[1,1,1,1,1],[1,0,0,1,0]]
 * 返回值：4
 */
public class Solution {
    /**
     * 最大正方形
     *
     * @param matrix char字符型二维数组
     * @return int整型
     */
    public int solve(char[][] matrix) {
        // write code here
        int[][] area = new int[matrix.length][matrix[0].length];

        int flag = matrix[0][0] - '0';
        for (int i = 0; i < area.length; i++) {
            if (flag == 1) {
                area[i][0] = 1;
            }
            if (matrix[i][0] == '1') {
                flag = 1;
                area[i][0] = 1;
            }

        }
        flag = matrix[0][0] - '0';
        for (int i = 0; i < area[0].length; i++) {
            if (flag == 1) {
                area[0][i] = 1;
            }
            if (matrix[0][i] == '1') {
                flag = 1;
                area[0][i] = 1;
            }
        }

        int max = 0;
        for (int i = 1; i < area.length; i++) {
            for (int j = 1; j < area[i].length; j++) {
                if (matrix[i][j] == '1') {
                    if (matrix[i - 1][j - 1] != '0' && matrix[i - 1][j] != '0' && matrix[i][j - 1] != '0') {
                        area[i][j] = Math.min(Math.min(area[i - 1][j], area[i][j - 1]), area[i - 1][j - 1]) + 1;
                    } else {
                        area[i][j] = 1;
                    }
                } else {
                    area[i][j] = 0;
                }
                if (area[i][j] > max) {
                    max = area[i][j];
                }
            }
        }
        return max * max;
    }
}

/**
 * 思路：
 * 每次计算当前点所能围城的最大面积的边长，纪录最大值。
 * 遍历matrix，
 * 1.当前点 matrix 值是 0 时，area 取 0；
 * 2.当前点 matrix 值是 1 时:
 * ···2.1.查看 matrix 中 当前点左上，上，左点的值，如果都是 1 ，当前的 area 取左上，左和上中最小的 +1；
 * ···2.2.否则，area取1；
 */

