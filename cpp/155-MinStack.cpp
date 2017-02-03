class MinStack {
    stack<int> s1;
    stack<int> min;
public:
    /** initialize your data structure here. */
    MinStack() {

    }

    void push(int x) {
        s1.push(x);
        if ( min.empty() || x <= min.top()){
            min.push(x);
        }
    }

    void pop() {
        if (s1.top() == min.top()){
            s1.pop();
            min.pop();
        }else{
            s1.pop();
        }
    }

    int top() {
        return s1.top();
    }

    int getMin() {
        return min.top();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
