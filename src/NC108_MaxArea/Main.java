package NC108_MaxArea;

/**
 * @Author WangBei
 * @Date 2021/8/11 15:51
 * @Description: NC108 最大正方形
 * 描述: 给定一个由'0'和'1'组成的2维矩阵，返回该矩阵中最大的由'1'组成的正方形的面积
 * <p>
 * 示例1
 * 输入： [[1,0,1,0,0],[1,0,1,1,1],[1,1,1,1,1],[1,0,0,1,0]]
 * 返回值：4
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1'}};

        int solve = s.solve(matrix);
        System.out.println(solve);
    }
}
