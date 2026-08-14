/**

    Use 2 stacks. one for storing elements, one for keeping track of the current min 
    element.

    we call these 2 stacks stack and minStack. stack is just regular push/pop/peek ops
    nothing special. For the minstack, every time a new element is pushed into stack,
    we check if the new element is new min, if so , we push new element into minStack. 
    Otherwise, we push the old min elewment into minstack. so getMin() will always 
    return minstack.peek(); When stack pops, minstack also pops.
*/

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack();
        this.minStack = new Stack();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val < minStack.peek()) {
            minStack.push(val);
        }
        else {
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}


// push 1
// push 2
// push 0
// getMin
// pop
// top
// getMin

//. stack:[1, 2]
//  minStack:[1, 1]
