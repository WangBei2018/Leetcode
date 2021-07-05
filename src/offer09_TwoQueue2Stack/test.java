package offer09_TwoQueue2Stack;

/**
 * @Author WangBei
 * @Date 2021/6/16 10:34
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        CStack cs = new CStack();

        cs.appendTail(1);
        cs.appendTail(2);
        cs.appendTail(3);


        System.out.println(cs.deleteHead());
        System.out.println(cs.deleteHead());
        System.out.println(cs.deleteHead());
        System.out.println(cs.deleteHead());
    }
}
