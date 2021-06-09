package largestIsland_827;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


class Solution {
    List<Integer> islandArea;

    public int largestIsland(int[][] grid) {
        islandArea = new ArrayList<>();                     // 存储每块陆地的面积，每块面积用不同的数字表示，当数字为0时则为海洋，数字>=2时为陆地
        int k = 2;
        islandArea.add(0);
        islandArea.add(0);                                  // 在添加两个0是为了，在后面将海洋变为陆地时，判断周围陆地面积
        for (int i = 0; i < grid.length; i++) {        // 遍历陆地节点，计算每块陆地的面积
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    int area = Area(grid, i, j, k);             // 计算每一个连通的陆地构成的岛的面积
                    islandArea.add(area);
                    k++;
                }
            }
        }

        int maxArea = Collections.max(islandArea);          // 防止所有的节点都是陆地时，如果初始化最大面积为0，则最终结果也是0，出错。
        for (int i = 0; i < grid.length; i++) {             // 遍历海洋，计算每个海洋和周围四个节点中的陆地能够连通的最大的面积
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0){
                    int area = newArea(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public int Area(int[][] grid, int r, int c, int k) {    // 计算陆地的面积
        if (!inArea(grid, r, c)) {
            return 0;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = k;
        return 1
                + Area(grid, r - 1, c, k)
                + Area(grid, r + 1, c, k)
                + Area(grid, r, c - 1, k)
                + Area(grid, r, c + 1, k);
    }

    public boolean inArea(int[][] grid, int r, int c) {         // 判断当前左边是否越界
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

    public int newArea(int[][] grid, int r, int c) {            // 计算新的连通区域的面积
        if (!inArea(grid, r, c)) {                              // 判断当前海洋是否越界
            return 0;
        }

        if (grid[r][c] != 0) {                                  // 当前坐标系下不是海洋
            return 0;
        }

        int area = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();         // 存放周围四个节点的面积

        // 若当前海洋点左边为越界
        if (inArea(grid, r - 1, c)) {
            hm.put(grid[r - 1][c], islandArea.get(grid[r - 1][c]));
        }

        if (inArea(grid, r + 1, c)) {
            hm.put(grid[r + 1][c], islandArea.get(grid[r + 1][c]));
        }

        if (inArea(grid, r, c - 1)) {
            hm.put(grid[r][c - 1], islandArea.get(grid[r][c - 1]));
        }
        if (inArea(grid, r, c + 1)) {
            hm.put(grid[r][c + 1], islandArea.get(grid[r][c + 1]));
        }

        for (Integer i : hm.keySet()) {
            area += hm.get(i);
        }
        return 1 + area;
    }
}





