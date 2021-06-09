package offer17_PrintNumbers;

/**
 * @Author WangBei
 * @Date 2021/6/7 20:58
 */
public class test {
    public static void main(String[] args) {
        Solution s = new Solution();
        String string = s.printNumbers(1);      // n=10,OutOfMemoryError
        System.out.println(string);

        System.out.println("------------------------------------------");
        SolutionInt s1 = new SolutionInt();
        int[] res = s1.printNumbers(3);        // n=10,OutOfMemoryError
        for (int i : res) {
            System.out.print(i + " ");
            if (i % 10 == 0) System.out.println();
        }

    }
}
