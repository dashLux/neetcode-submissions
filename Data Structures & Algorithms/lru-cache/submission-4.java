class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    Map<Integer, Node> cache;
    int capacity;
    Node MRU;
    Node LRU;
    

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.MRU = new Node(-1, -1);
        this.LRU = new Node(-1, -1);
        LRU.next = MRU;
        MRU.prev = LRU;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        //mark node as most recenly used
        Node node = cache.get(key);
        //remove node from original position
        node.prev.next = node.next;
        node.next.prev = node.prev;

        //insert node to most recently used
        MRU.prev.next = node;
        node.prev = MRU.prev;
        node.next = MRU;
        MRU.prev = node;

        return node.value;
    }
    
    public void put(int key, int value) {
        //if key exists, no size change, only need to move node to MRU
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            //remove node from original position
            node.prev.next = node.next;
            node.next.prev = node.prev;

            //insert node to most recently used
            MRU.prev.next = node;
            node.prev = MRU.prev;
            node.next = MRU;
            MRU.prev = node;

            return;
        }

        //creating new mapping
        Node node = new Node(key, value);
        cache.put(key, node);
        if (cache.size() > capacity) {
            //purge LRU node
            Node lruNode = LRU.next;
            LRU.next = lruNode.next;
            lruNode.next.prev = LRU;

            //remove entry from cache
            cache.remove(lruNode.key);
        }
        //insert node to most recently used
        MRU.prev.next = node;
        node.prev = MRU.prev;
        node.next = MRU;
        MRU.prev = node;
        return;
    }
}
