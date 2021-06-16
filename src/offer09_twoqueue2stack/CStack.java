package offer09_twoqueue2stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author WangBei
 * @Date 2021/6/16 10:19
 * @Description:两个队列实现栈
 */
public class CStack {
    Queue<Integer> A, B;

    public CStack() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void appendTail(int value) {
        if (!A.isEmpty()) {
            A.offer(value);
            return;
        }
        if (!A.isEmpty())
        {
            B.offer(value);
            return;
        }
        A.offer(value);
    }

    public int deleteHead() {
        if(!A.isEmpty()){
            int num = A.poll();
            if(A.isEmpty()) return num;
            B.offer(num);
        }
        if(!B.isEmpty()){
            int num = B.poll();
            if(B.isEmpty()) return num;
            A.offer(num);
        }
        return -1;
    }
}
