class MyStack {
public:
    queue<int> q1;
    queue<int> q2;

    /** Initialize your data structure here. */
    MyStack() {

    }

    /** Push element x onto stack. */
    void push(int x) {
        if (q1.empty()){
            q1.push(x);
            while (!q2.empty()){
                q1.push(q2.front());
                q2.pop();
            }
        }else{
            q2.push(x);
            while (!q1.empty()){
                q2.push(q1.front());
                q1.pop();
            }
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    int pop() {
        if (!q1.empty()){
            int res = q1.front();
            q1.pop();
            return res;
        }else{
            int res = q2.front();
            q2.pop();
            return res;
        }
    }

    /** Get the top element. */
    int top() {
        return !q1.empty() ? q1.front() : q2.front();
    }

    /** Returns whether the stack is empty. */
    bool empty() {
        return q1.empty() && q2.empty();
    }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * bool param_4 = obj.empty();
 */

 //One queue:
 class MyStack {
public:
    queue<int> q;

    /** Initialize your data structure here. */
    MyStack() {

    }

    /** Push element x onto stack. */
    void push(int x) {
        q.push(x);
        for (int i = 1; i < q.size(); i++){
            int item = q.front();
            q.pop();
            q.push(item);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    int pop() {
        int item = q.front();
        q.pop();
        return item;
    }

    /** Get the top element. */
    int top() {
        return q.front();
    }

    /** Returns whether the stack is empty. */
    bool empty() {
        return q.empty();
    }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * bool param_4 = obj.empty();
 */
