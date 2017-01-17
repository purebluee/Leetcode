
public class LFUCache {
    private int capacity;
    private int count;
    private HashMap<Integer, Tuple> map1; // whether appeared
    private HashMap<Integer, Tuple> finalNodes; // value : the final node of key times
    private Tuple dummyHead;
    private Tuple dummyEnd;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        map1 = new HashMap<Integer, Tuple>();
        finalNodes = new HashMap<>();
        dummyHead = new Tuple(0, 0, 0);
        dummyEnd = new Tuple(0, 0, 0);
        dummyHead.next = dummyEnd;
        dummyEnd.prev = dummyHead;
    }
    
    public int get(int key) {
        if (capacity == 0 || !map1.containsKey(key)) {
            return -1;
        }
        Tuple old = map1.get(key);
        put(key, old.value);
        return old.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (map1.containsKey(key)) { // this key has appeared
            Tuple cur = map1.get(key);
            if (finalNodes.get(cur.times) == cur && finalNodes.get(cur.times + 1) == null) { // the position should not change
                finalNodes.put(cur.times, cur.prev.times == cur.times ? cur.prev : null);
                cur.times++;
                cur.value = value;
                finalNodes.put(cur.times, cur);
                return;
            }
            removeNode(cur); // remove node cur
            if (finalNodes.get(cur.times) == cur) {
                finalNodes.put(cur.times, cur.prev.times == cur.times ? cur.prev : null);
            }
            cur.times++;
            cur.value = value;
            Tuple finalNode = finalNodes.get(cur.times) == null ? finalNodes.get(cur.times - 1) : finalNodes.get(cur.times);
            insertNode(finalNode, cur); 
            finalNodes.put(cur.times, cur); // cur is the final node whitch appeared cur.times
        } else if (count == capacity) { // reach limt of the cache
            Tuple head = dummyHead.next;
            removeNode(head); //remove the first which appeared least times and is the least Used
            map1.remove(head.key);
            if (finalNodes.get(head.times) == head) {
                finalNodes.remove(head.times);
            }
            Tuple cur = new Tuple(key, value, 1);
            if (finalNodes.get(1) == null) {
                insertNode(dummyHead, cur);
            } else {
                Tuple finalNode = finalNodes.get(1);
                insertNode(finalNode, cur);
            }
            finalNodes.put(1, cur);
            map1.put(key, cur);
        } else {
            count++;
            Tuple cur = new Tuple(key, value, 1);
            if (finalNodes.get(1) == null){
               insertNode(dummyHead, cur);
            } else {
                Tuple finalNode = finalNodes.get(1);
                insertNode(finalNode, cur);
            }
            finalNodes.put(1, cur);
            map1.put(key, cur);
        }
    }
    
    public void insertNode(Tuple t1, Tuple t2) {
        t2.next = t1.next;
        t1.next.prev = t2;
        t1.next = t2;
        t2.prev = t1;
    }
    
    public void removeNode(Tuple node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    class Tuple {
        int key;
        int value;
        int times;
        Tuple prev;
        Tuple next;
        public Tuple(int key, int value, int times) {
            this.key = key;
            this.value = value;
            this.times = times;
        }
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */