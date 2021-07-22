package Interview16_25_LRUCache;

/**
 * @Author WangBei
 * @Date 2021/7/21 16:29
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));
        cache.put(1, 1);
        cache.put(4, 1);
        System.out.println(cache.get(2));
    }
}
