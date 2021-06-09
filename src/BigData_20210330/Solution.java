package BigData_20210330;

public class Solution {
    StringBuilder res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public String printNumbers(int n) {
        this.n = n;
        res = new StringBuilder();
        num = new char[n];
        start = n - 1;
        dfs(0);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    void dfs(int x) {
        if (x == n) {
            String s1 = String.valueOf(num);

            // 截取s1前start个字符，并返回剩下的字符串，
            // 例如： String day = "Today is Monday";
            // System.out.println("substring(2)结果："+day.substring(2));
            // substring(2)结果：day is Monday
            String s = s1.substring(start);
            if (!s.equals("0")) res.append(s + ",");
            if (n - start == nine) start--;
            return;
        }
        for (char i : loop) {
            if (i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = s.printNumbers(3);
        System.out.println(s1);
    }
}
