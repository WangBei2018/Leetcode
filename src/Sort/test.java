package Sort;

/**
 * @Author WangBei
 * @Date 2021/6/23 16:15
 * @Description:
 */
public class test {
    public static void main(String[] args) {

        // 快速排序
        int[] seq = {48, 62, 35, 77, 55, 14, 35, 98};
        quickSort sort = new quickSort(seq);
        sort.QuickSort(seq, seq.length, 0, seq.length - 1);
        for (int num : seq) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 插入排序
        seq = new int[]{48, 62, 35, 77, 55, 14, 35, 98};
        insSort is = new insSort();
        int[] isSeq = is.InsSort(seq);
        for (int num : isSeq) {
            System.out.print(num + " ");
        }

        // 冒泡排序




        // 希尔排序



        // 2-路归并排序



    }
}
