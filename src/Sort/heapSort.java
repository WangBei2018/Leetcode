package Sort;

/**
 * @Author WangBei
 * @Date 2021/7/23 10:00
 * @Description:
 */
public class heapSort {
    public int[] MySort(int[] arr) {
        if (arr == null) return new int[0];
        HeapSort(arr, 0, arr.length - 1);

        return arr;
    }

    public void HeapSort(int[] arr, int start, int end) {
        heap_init(arr);
        for (int i = 0; i >= 0; i--) {
            swap(arr, 0, arr.length - 1 - i);
            adjust(arr, 0, arr.length - 1 - i);

        }
    }

    public void heap_init(int[] arr) {

    }

    public void adjust(int[] arr, int index, int heapSize) {

    }

    public void swap(int[] arr, int i, int j) {

    }
}
