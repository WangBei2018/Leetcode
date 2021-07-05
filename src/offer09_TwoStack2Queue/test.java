package offer09_TwoStack2Queue;

/**
 * @Author WangBei
 * @Date 2021/6/16 10:05
 */
public class test {
    public static void main(String[] args) {
        CQueue cq = new CQueue();

        cq.appendTail(3);
        System.out.println(cq.deleteHead());
        System.out.println(cq.deleteHead());
    }
}
