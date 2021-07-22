package offer09_TwoStack2Queue;

/**
 * @Author WangBei
 * @Date 2021/6/16 10:05
 */
public class test {
    public static void main(String[] args) {
        CQueue cq = new CQueue();

        cq.appendTail(3);
        cq.appendTail(2);
        System.out.println(cq.deleteHead());

        cq.appendTail(1);
        System.out.println(cq.deleteHead());
    }
}
