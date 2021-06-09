package offer17_PrintNumbers;

/**
 * @Author WangBei
 * @Date 2021/6/8 9:12
 */

/*
题目：输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
示例 1:
    输入: n = 1
    输出: [1,2,3,4,5,6,7,8,9]
说明：
    用返回一个整数列表来代替打印
    n 为正整数

只能打印int取值范围内的数字
*/

public class SolutionInt {
    char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    char[] num;                         // 表示当前正在进行的数字，添加的字符串为num[start:end]
    int start, nine = 0, n, count = 0;  // nine：当前数字中9的个数，start：num中有效的（出去高位多余的0）数字开始，n:最终需要表示的位数,count:res的下标
    int[] res;                          // 最终保存所有数字的容器

    public int[] printNumbers(int n) {
        num = new char[n];
        start = n - 1;                  // 首先是一位的数字，所以是n-1
        this.n = n;
        res = new int[(int) Math.pow(10, n) - 1];
        dfs(0);                      // 开启全排列递归
        return res;
    }

    public void dfs(int x) {
        if (x == n) {               // 终止条件：已固定完所有位
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) {   // 打印从1开始，所以去掉第一位的0
                // 使用了Integer类中的parseInt()方法，此时默认s未超出int表示的范围 2^31-1 ~ -2^31，
                // 如果需要打印的是大数，即超出了int的范围时，则不能使用这个，必须使用String来表示

                res[count] = Integer.parseInt(s);
                count++;
            }
            if (n - start == nine) start--;     // 当前位数的数字表示完，接着增加一位
            return;
        }

        for (char c : loop) {           // 递归生成全排列
            if (c == '9') {
                nine++;
            }
            num[x] = c;                 // 固定第 x 位为 c
            dfs(x + 1);
        }
        nine--;                         // 第 x 位变成下一个数字此时x-1为的9消失
    }
}
