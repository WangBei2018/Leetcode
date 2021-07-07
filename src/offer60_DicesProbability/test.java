package offer60_DicesProbability;

/**
 * @Author WangBei
 * @Date 2021/7/7 9:55
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 3;          // [0.00463,0.01389,0.02778,0.0463,0.06944,0.09722,0.11574,0.125,0.125,0.11574,0.09722,0.06944,0.0463,0.02778,0.01389,0.00463]
        double[] probability = s.dicesProbability(n);
        for (double pro : probability) {
            System.out.print(pro + " ");
        }
    }
}
