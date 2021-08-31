package NC_ZJ1_MovingSteps;

import java.util.Scanner;

/**
 * @Author WangBei
 * @Date 2021/8/10 16:46
 * @Description: ZJ1 附加题
 * 描述: 存在n+1个房间，每个房间依次为房间1 2 3...i，每个房间都存在一个传送门，i房间的传送门可以把人传送到房间pi(1<=pi<=i),现在路人甲从房间1开始出发(当前房间1即第一次访问)，每次移动他有两种移动策略：
 * A. 如果访问过当前房间 i 偶数次，那么下一次移动到房间i+1；
 * B. 如果访问过当前房间 i 奇数次，那么移动到房间pi；
 * 现在路人甲想知道移动到房间n+1一共需要多少次移动；
 * <p>
 * 输入描述： 第一行包括一个数字n(30%数据1<=n<=100，100%数据 1<=n<=1000)，表示房间的数量，接下来一行存在n个数字 pi(1<=pi<=i), pi表示从房间i可以传送到房间pi。
 * 输出描述：输出一行数字，表示最终移动的次数，最终结果需要对1000000007 (10e9+7) 取模。
 * <p>
 * 示例1
 * 输入： 2
 * 1 2
 * 输出： 4
 * <p>
 * 说明：开始从房间1 只访问一次所以只能跳到p1即 房间1， 之后采用策略A跳到房间2，房间2这时访问了一次因此采用策略B跳到房间2，之后采用策略A跳到房间3，因此到达房间3需要 4 步操作。
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] room = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            room[i] = sc.nextInt();
        }

        int steps = movingSteps(n, room);
        System.out.println(steps);
    }

    public static int movingSteps(int n, int[] room) {
        int cur = 1;
        int steps = 1;
        int[] count = new int[n + 2];
        count[cur] = 1;
        while (cur != n + 1) {
            if (count[cur] % 2 != 0) {
                cur = room[cur];
            } else {
                cur++;
            }
            count[cur]++;
            steps = (steps + 1) % 1000000007;
        }
        return (steps + 1000000007 - 1) % 1000000007;
    }

}
// 超时，还需修改



