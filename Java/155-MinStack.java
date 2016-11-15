public class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> ms = new Stack<>();

    public MinStack() {
        
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