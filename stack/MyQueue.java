package stack;

import java.util.Stack;

class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> stack2;

    public MyQueue() {
        this.stack = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void push(int x) {
        this.stack.push(x);
    }

    public int pop() {
        if (this.stack2.empty()) {
            while (!this.stack.empty()) {
                int temp = this.stack.pop();
                this.stack2.push(temp);
            }
        }
        return this.stack2.pop();
    }

    public int peek() {
        if (this.stack2.empty()) {
            while (!this.stack.empty()) {
                int temp = this.stack.pop();
                this.stack2.push(temp);
            }
        }
        return this.stack2.peek();
    }

    public boolean empty() {
        return this.stack.empty() && this.stack2.empty();
    }

}
