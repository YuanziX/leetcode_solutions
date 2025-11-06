class DDLLNode {
    DDLLNode pre;
    DDLLNode post;
    int key;
    int value;

    DDLLNode(int k, int v) {
        key = k;
        value = v;
    }
}

class DDLL {
    DDLLNode head;
    DDLLNode tail;
    
    DDLL() {
        head = new DDLLNode(-1, -1);
        tail = new DDLLNode(-1, -1);
        head.post = tail;
        tail.pre = head;
    }

    void add(DDLLNode node) {
        node.pre = head;
        node.post = head.post;


        head.post.pre = node;
        head.post = node;
    }

    void remove(DDLLNode node) {
        DDLLNode pre = node.pre;
        DDLLNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    void moveToHead(DDLLNode node) {
        remove(node);
        add(node);
    }

    DDLLNode popTail() {
        DDLLNode res = tail.pre;
        remove(res);
        return res;
    }
}

class LRUCache {
    DDLL dl;
    Map<Integer, DDLLNode> hm;
    int c;

    public LRUCache(int capacity) {
        c = capacity;
        dl = new DDLL();
        hm = new HashMap<>();
    }
    
    public int get(int key) {
        DDLLNode node = hm.get(key);
        if (node == null) return -1;
        dl.moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DDLLNode node = hm.get(key);
        if (node != null) {
            node.value = value;
            dl.moveToHead(node);
        } else {
            DDLLNode nn = new DDLLNode(key, value);
            if (hm.size() == c) {
                hm.remove(dl.popTail().key);
            }
            hm.put(key, nn);
            dl.add(nn);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */