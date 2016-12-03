class MyStack {
    Queue<Integer> q = new LinkedList<>();
    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
        for (int i = 1; i < q.size(); i++)
            q.add(q.poll());
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.remove();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }


    //with two queues
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public Integer peek() {
       return q1.isEmpty() ? q2.peek() : q1.peek();
    }

    public Integer pop() {
       if (!q1.isEmpty()){
           q1.poll();
       }else{
           q2.poll();
       }
    }

    public void push(Integer item) {
       if (q1.isEmpty()){
           q1.add(item);
           for (int i = 0; i < q2.size(); i++){
               q1.add(q2.poll());
           }
       }else{
           q2.add(item);
           for (int i = 0; i < q1.size(); i++){
               q2.add(q1.poll());
           }
       }
    }

    public boolean isEmpty() {
       return q1.isEmpty() && q2.isEmpty();
    }
}