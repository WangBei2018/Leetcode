package offer12_HasPath;

/**
 * @Author WangBei
 * @Date 2021/6/26 10:23
 * @Description:
 * 题目：给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 *      单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例 1：
 *      输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 *      输出：true
 * 示例 2：
 *      输入：board = [["a","b"],["c","d"]], word = "abcd"
 *      输出：false
 * 提示：
 *      1 <= board.length <= 200
 *      1 <= board[i].length <= 200
 *      board 和 word 仅由大小写英文字母组成
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1 || board[0].length < 1 || word.length() == 0) return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (DFS(board, word, i, j, 0)) return true;         // 寻找word开始字符的位置，并开始遍历board数组查找路径
            }
        }
        return false;
    }

    public boolean DFS(char[][] board, String word, int i, int j, int k) {
        // 剪枝条件：当前位置越界或者当前位置的字符不是需要查询路径的字符
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(k))
            return false;

        // 找到路径，不能写在上一个if之前，因为当最后一个字符不符合时，此时if的值也会是true，所以必须在board[i][j] == word.charAt(k)之后才能为true
        if (k == word.length() - 1) return true;

        // 防止重复走过某个点
        board[i][j] = ' ';

        // 遍历上下左右节点，并判断是否能走通
        boolean res = DFS(board, word, i - 1, j, k + 1)
                || DFS(board, word, i + 1, j, k + 1)
                || DFS(board, word, i, j - 1, k + 1)
                || DFS(board, word, i, j + 1, k + 1);

        // 还原board中路径的值，防止在回溯时出错
        board[i][j] = word.charAt(k);

        return res; // 返回结果
    }
}
