package offer17_PrintNumbers;

/**
 * @Author WangBei
 * @Date 2021/6/7 20:57
 */

/*
题目：输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
示例 1:
    输入: n = 1
    输出: [1,2,3,4,5,6,7,8,9]
说明：
    用返回一个整数列表来代替打印
    n 为正整数

能表示超出int范围的大数，真正的大数表示
*/


public class Solution {
    char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    char[] num;             // 表示当前正在进行的数字，添加的字符串为num[start:end]
    StringBuilder res;      // 最终保存所有数字的容器
    int nine = 0, start, n; // nine：当前数字中9的个数，start：num中有效的（出去高位多余的0）数字开始，n:最终需要表示的位数

    public String printNumbers(int n) {
        num = new char[n];
        res = new StringBuilder();  // 数字字符串集
        start = n - 1;      // 首先是一位的数字，所以是n-1
        this.n = n;

        dfs(0);         // 开启全排列递归
        res.delete(res.length() - 1, res.length() - 1); // 将最后多余的","删除掉
//        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public void dfs(int x) {
        if (x == n) {               // 终止条件：已固定完所有位
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) {   // 打印从1开始，所以去掉第一位的0
                res.append(s);
                res.append(",");    // 拼接 num 并添加至 res 尾部，使用逗号隔开
            }
            if (n - start == nine) start--; // 当前位数的数字表示完，接着增加一位
            return;
        }
        for (char c : loop) {       // 递归生成全排列
            if (c == '9') nine++;
            num[x] = c;         // 固定第 x 位为 c
            dfs(x + 1);      // 开启固定第 x + 1 位
        }
        nine--;                 // 第 x 位变成下一个数字此时x-1为的9消失
    }
}
