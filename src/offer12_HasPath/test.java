package offer12_HasPath;

/**
 * @Author WangBei
 * @Date 2021/6/26 10:24
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        Solution s = new Solution();
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "ABCCED";

        char[][] board = {{'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A'}};
//        String word = "AAAAAAAA";
        String word = "ABCCED";

//        char[][] board = {{'A', 'B', 'C', 'E'}};
//        String word = "ABCCED";

        boolean res = s.exist(board, word);
        System.out.println(res);
    }
}
