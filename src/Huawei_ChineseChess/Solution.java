package Huawei_ChineseChess;

/**
 * @Author WangBei
 * @Date 2021/7/7 21:30
 * @Description:
 */
public class Solution {
    int step = 0;
    int[][] visited;

    public int chineseChess(int w, int h, char[][] chessboard) {
        visited = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (chessboard[i][j] == 'H') {
                    step = DFS(w, h, i, j, chessboard);
                    break;
                }
            }
        }

        return step;
    }

    public int DFS(int w, int h, int i, int j, char[][] chessboard) {
        if (i < 0 || i >= w || j < 0 || j >= h || chessboard[i][j] == '#' || visited[i][j] != 0) return -1;
        System.out.println(i + "," + j);
        visited[i][j] = 1;
        if (chessboard[i][j] == 'T') return 0;
        if (i > 0 && chessboard[i - 1][j] != '#') {
            step += 1 + DFS(w, h, i - 2, j - 1, chessboard) + 1 + DFS(w, h, i - 2, j + 1, chessboard);
        }
        if (i < w - 1 && chessboard[i + 1][j] != '#') {
            step += 1 + DFS(w, h, i + 2, j - 1, chessboard) + 1 + DFS(w, h, i + 2, j + 1, chessboard);
        }
        if (j > 0 && chessboard[i][j - 1] != '#') {
            step += 1 + DFS(w, h, i - 1, j - 2, chessboard) + 1 + DFS(w, h, i + 1, j - 2, chessboard);
        }
        if (j < h - 1 && chessboard[i][j + 1] != '#') {
            step += 1 + DFS(w, h, i - 1, j + 2, chessboard) + 1 + DFS(w, h, i + 1, j + 2, chessboard);
        }


        return step;

    }
}
