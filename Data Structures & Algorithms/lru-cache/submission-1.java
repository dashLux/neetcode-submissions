class Node {
    int val;
    Node prev;
    Node next;
    int key;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Map<Integer, Node> map;
    Node LRU;
    Node MRU;
    int capacity;
    

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.LRU = new Node(-1, -1);
        this.MRU = new Node(-1, -1);
        this.LRU.next = this.MRU;
        this.MRU.prev = this.LRU;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            Node before = this.MRU.prev;
            before.next = node;
            node.prev = before;
            node.next = this.MRU;
            this.MRU.prev = node;

            return node.val;

        }
        else {
            return -1;
        }
        
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            //update value, move node to MRU
            Node node = map.get(key);
            node.val = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            Node before = this.MRU.prev;
            before.next = node;
            node.prev = before;
            node.next = this.MRU;
            this.MRU.prev = node;
            return;
        }
        
        Node create = new Node(key, value);
        if (map.size() == capacity) {
            //evict LRU node
            Node evict = LRU.next;
            LRU.next = evict.next;
            evict.next.prev = LRU;
            
            //remove from hashmap
            map.remove(evict.key);
        }

        //add new node to linked list
        Node before = this.MRU.prev;
        before.next = create;
        create.prev = before;
        create.next = this.MRU;
        this.MRU.prev = create;

        //add new entry to hashmap
        map.put(key, create);
        return;
    }
}
