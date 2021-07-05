package offer09_TwoStack2Queue;

import java.util.Stack;

/**
 * @Author WangBei
 * @Date 2021/6/16 10:05
 * @Description:两个栈实现队列
 */

public class CQueue {
    Stack<Integer> A,B;

    public CQueue() {
        A = new Stack<>();
        B = new Stack<>();

    }

    public void appendTail(int value) {
        A.push(value);
    }

    public int deleteHead() {
        if(!B.empty()) return B.pop();
        if(A.empty()) return -1;
        while(!A.empty()){
            B.push(A.pop());
        }
        return B.pop();
    }
}
