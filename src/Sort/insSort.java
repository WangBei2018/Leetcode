package Sort;

/**
 * @Author WangBei
 * @Date 2021/6/25 10:23
 * @Description:插入排序,升序
 */
public class insSort {
    public int[] InsSort(int[] seq) {
        if (seq == null) return new int[0];
        for (int i = 1; i < seq.length; i++) {
            int j = i - 1;
            int num = seq[i];
            while (j >= 0) {
                if (num < seq[j]) {
                    seq[j + 1] = seq[j];
                    j--;
                } else {
                    seq[j + 1] = num;
                    break;
                }
            }
            if (j < 0) {
                seq[0] = num;
            }
        }
        return seq;
    }
}
