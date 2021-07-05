package offer13_MovingCount;

/**
 * @Author WangBei
 * @Date 2021/6/26 11:35
 * @Description: 题目：地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的 数位之和 大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 * <p>
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * <p>
 * 提示：
 * 1 <= n,m <= 100
 * 0 <= k<= 20
 */
public class Solution {
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k < 0) return 0;
        visited = new boolean[m][n];
        return DFS(m, n, 0, 0, k) + 1;          // +1是因为在进行DFS时没有加上最开始[0,0]位置的方格
    }

    public int DFS(int m, int n, int i, int j, int k) {
        int sum = 0;
        int num1 = i;
        int num2 = j;
        // 计算当前横纵坐标的数位之和
        while (num1 != 0) {
            sum += num1 % 10;
            num1 = num1 / 10;
        }
        while (num2 != 0) {
            sum += num2 % 10;
            num2 = num2 / 10;
        }

        // 越界，访问过或当前位置数位之和大于k时
        if (i > m - 1 || j > n - 1 || sum > k || visited[i][j]) {
            return -1;
        }
        visited[i][j] = true;           // 访问标志位

        // 继续进行深度优先遍历，遍历下一个位置
        return DFS(m, n, i + 1, j, k) + 1
                + DFS(m, n, i, j + 1, k) + 1;
    }

    public int Sum(int i) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }
}
