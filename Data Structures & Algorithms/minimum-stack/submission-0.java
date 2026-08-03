class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack();
        this.minStack = new Stack();
    }
    
    public void push(int val) {
        // push val into main stack, check if val is the new min, yes -> push val into min
        // stack. no -> push top element in the minstack again
        stack.push(val);
        if (minStack.isEmpty() || val < minStack.peek()) {
            minStack.push(val);
        }
        else {
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        // pop top element from both main stack and min stack
        if (!stack.isEmpty()) {
            stack.pop();
        }

        if (!minStack.isEmpty()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
