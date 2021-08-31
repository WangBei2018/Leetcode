package NC127_LCS;

/**
 * @Author WangBei
 * @Date 2021/8/20 11:29
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "2LQ74WK8Ld0x7d8FP8l61pD7Wsz1E9xOMp920hM948eGjL9Kb5KJt80";
        String s2 = "U08U29zzuodz16CBZ8xfpmmn5SKD80smJbK83F2T37JRqYfE76vh6hrE451uFQ100ye9hog1Y52LDk0L52SuD948eGjLz0htzd5YF9J1Y6oI7562z4T2";
        String string = s.LCS(s1, s2);
        System.out.println(string);
    }
}
