package Huawei_ChineseChess;

/**
 * @Author WangBei
 * @Date 2021/7/7 21:33
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int w = 5, h = 13;
        char[][] chessboard = {{'.', '.', '.', '.', '.', '.', '.', '.', 'H', '.', '.', '.', '#'},
                               {'.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.'},
                               {'.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.'},
                               {'.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                               {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'T', '#', '.'}};
        System.out.println(s.chineseChess(w, h, chessboard));
    }
}
