package newcodetop200.part2;

import java.util.Stack;

public class ImplementQueueUsingStacks232 {
    public static void main(String[] args) {

    }

    private Stack<Integer> s1, s2;

    public ImplementQueueUsingStacks232() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * 添加元素到队尾
     */
    public void push(int x) {
        s1.push(x);
    }

    /**
     * 返回队头元素
     */
    public int peek() {
        if (s2.isEmpty()){
            // 把 s1 元素压入 s2
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    /**
     * 删除队头的元素并返回
     */
    public int pop() {
        // 先调用 peek 保证 s2 非空
        peek();
        return s2.pop();
    }

    /**
     * 判断队列是否为空
     */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
