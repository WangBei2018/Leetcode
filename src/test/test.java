package test;


public class test {
    void DFS(int[][] grid, int r, int c) {
        // 判断 base case：如果坐标 (r, c) 超出了网格范围，直接返回
        if (!inArea(grid, r, c)) {
            return;
        }

        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c] != 1){
            return;
        }
        grid[r][c] = 2;             // 将格子标记为「已遍历过」


        // 访问上、下、左、右四个相邻结点
        DFS(grid, r - 1, c);    // 上
        DFS(grid, r + 1, c);    // 下
        DFS(grid, r, c - 1);    // 左
        DFS(grid, r, c + 1);    // 右

    }

    // 判断坐标 (r, c) 是否在网格中
    boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
