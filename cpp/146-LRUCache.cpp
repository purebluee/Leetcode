class LRUCache {
private:
    struct Node{
        int key;
        int val;
        Node* prev;
        Node* next;
        //CacheNode() : val(0), prev(NULL), next(NULL){}
        Node(int k, int v) : key(k), val(v), prev(NULL), next(NULL){}
    };

    int maxSize;
    Node* head;
    Node* tail;
    unordered_map<int, Node*> keyToNode;

    void insertToEnd(int key, int val){
        if (isFull() || keyToNode.count(key) != 0)
            return;
        Node* node = new Node(key, val);
        keyToNode[key] = node;
        if (!head){
            head = tail = node;
        }else{
            tail->next = node;
            node->prev = tail;
            tail = tail->next;
        }
    }

    void removeHead(){
        if (!head){
            return;
        }
        keyToNode.erase(head->key);
        Node* tmp = head;
        if (head == tail) //only one node remaining
            head = tail = NULL;
        else{
            head = head->next;
            head->prev = NULL;
        }
        delete tmp;
    }

    void moveToEnd(int key){
        //key doesn't exist, or already at the end
        if (keyToNode.count(key) == 0 || keyToNode[key] == tail)
            return;
        Node* node = keyToNode[key];
        if (node == head){
            head = head->next;
            head->prev = NULL;
        }else{ // not head, not tail
            node->prev->next = node->next;
            node->next->prev = node->prev;
        }
        tail->next = node;
        node->prev = tail;
        node->next = NULL;
        tail = tail->next;
    }

public:
    LRUCache(int capacity) : maxSize(capacity), head(NULL), tail(NULL) {
        keyToNode.clear();
    }

    int get(int key) {
        if (keyToNode.count(key) == 0)
            return -1;
        moveToEnd(key);
        return keyToNode[key]->val;
    }

    void put(int key, int value) {
        //key already exists
        if (get(key) != -1){
            keyToNode[key]->val = value;
            return;
        }

        //key doesn't exist, insert new node
        if (isFull())
            removeHead();
        insertToEnd(key, value);
    }

    bool isFull(){
        return keyToNode.size() >= maxSize;
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
