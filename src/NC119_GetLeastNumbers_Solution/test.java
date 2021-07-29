package NC119_GetLeastNumbers_Solution;

import java.util.ArrayList;

/**
 * @Author WangBei
 * @Date 2021/7/24 14:12
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = {0,1,2,1,2};
        int k = 3;
        ArrayList<Integer> res = s.GetLeastNumbers_Solution(input, k);
        for (Integer num : res) {
            System.out.print(num + " ");
        }
    }
}
