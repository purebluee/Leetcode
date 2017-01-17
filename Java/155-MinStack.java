//two stacks
//using two build in Java stack to store the stack and min values separately.
class MinStack {
    // stack: store the stack numbers
    private Stack<Integer> stack = new Stack<Integer>();
    // minStack: store the current min values
    private Stack<Integer> minStack = new Stack<Integer>();
    
    public void push(int x) {
        // store current min value into minStack
        if (minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
        stack.push(x);
    }

    public void pop() {
        // use equals to compare the value of two object, if equal, pop both of them
        if (stack.peek().equals(minStack.peek()))
            minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

//one stack

public class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> ms;

    public MinStack() {
        ms = new Stack<>();
    }
    
    public void push(int x) {
        if (x <= min){//pay attention!
            ms.push(min);
            min = x;
        }
        ms.push(x);
    }
    
    public void pop() {
        if (ms.peek() == min){
            ms.pop();
            min = ms.pop();
        }else
            ms.pop();
    }
    
    public int top() {
        return ms.peek();
    }
    
    public int getMin() {
        return min;
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */