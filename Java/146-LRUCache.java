/*
Note that all cache operations require O(1) time complexity. To achieve, we use hash map + doubly linked list. 
Why we use doubly linked list? Because we when delete a node or move the node to head, we shall do it in O(1) time. A singly linked list cannot achieve this. 

Discussion:
Note in Line 58 and 62, handle the null pointer exception. That is, if the head or tail node is null, you cannot set its pre node and next node to null as well. 

In this solution, all operations take O(1) time. Since we used hash map to store the key-node pairs, the space complexity is O(n) in additional to the O(n) cost on storing the linked list. 
Summary:
This question is kind of complicated to implement. It is unlikely to implement the full LRU during a code interview. 
However, you can at least answer the hash map + doubly linked list solution.  Note the doubly linked list idea. 
If you are asked to insert or delete an item in O(1) time, doubly linked list is a good candidate. 

*/

public class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head;
    private Node tail;
    private int len;
     
    public LRUCache(int capacity) {
        this.capacity = capacity;
        len = 0;
    }
     
    public int get(int key) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            removeNode(temp);
            insertHead(temp);
             
            return temp.val;
        } else {
            return -1;
        }
    }
     
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            // update the node
            temp.val = value;
             
            removeNode(temp);
            insertHead(temp);
            map.put(key, temp);
 
        } else { // do not contain
            Node temp = new Node(key, value);
            if (len < capacity) {
                insertHead(temp);
                map.put(key, temp);
                len++;
            } else if (len == capacity) {
                map.remove(tail.key);
                removeTail();
                insertHead(temp);
                map.put(key, temp);
            }
        }
    }
     
    private void removeNode(Node node) {
        Node curNode = node;
        Node preNode = node.pre;
        Node nextNode = node.next;
         
        if (preNode == null) {
            head = head.next;
            if (head == null) tail = head;
            else head.pre = null;
        } else if (nextNode == null) {
            tail = tail.pre;
            if (tail == null) head = tail;
            else tail.next = null;
        } else {
            preNode.next = nextNode;
            nextNode.pre = preNode;
        }
    }
     
    private void insertHead(Node node) {
        if (head == null) {
            head = node;
            tail = head;
            head.pre = null;
            tail.next = null;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
            head.pre = null;
        }
    }
     
    private void removeTail() {
        tail = tail.pre;
        if (tail == null) head = tail;
        else tail.next = null;
    }
     
     
    // Doubly linked list
    private class Node {
        public int key;
        public int val;
        public Node pre;
        public Node next;
         
        Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}