//Node: key, value, next, prev
// Map<Key, Node> map
//LRU <-> n1 <-> n2 <-> MRU
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
        this.cache = new HashMap<>();  
        this.capacity = capacity;
        this.MRU = new Node(-1, -1);
        this.LRU = new Node(-1, -1);
        this.LRU.next = MRU;
        this.MRU.prev = LRU;
        
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);

        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = MRU.prev;
        node.prev.next = node;
        node.next = MRU;
        MRU.prev = node;

        return node.value;
        
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.prev = MRU.prev;
            node.prev.next = node;
            node.next = MRU;
            MRU.prev = node;
        }
        else {
            Node node = new Node(key, value);
            cache.put(key, node);

            node.prev = MRU.prev;
            node.prev.next = node;
            node.next = MRU;
            MRU.prev = node;

            if (cache.size() > capacity) {
                Node evict = LRU.next;
                LRU.next = evict.next;
                evict.next.prev = LRU;
                cache.remove(evict.key);

            }
        }
    }
}
