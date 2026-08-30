class Node {
    String key;
    String value;
    int timestamp;

    public Node(String key, String value, int timestamp) {
        this.key = key;
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap {
    Map<String, List<Node>> timeMap;

    public TimeMap() {
        this.timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        this.timeMap.computeIfAbsent(key, v -> new ArrayList<>()).add(new Node(key, value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }

        List<Node> values = timeMap.get(key);
        int l = 0;
        int r = values.size() - 1;
        String potential = "";
        
        while(l <= r) {
            int m = l + (r - l) / 2;
            Node n = values.get(m);
            if (n.timestamp == timestamp) {
                return n.value;
            }
            else if (n.timestamp < timestamp) {
                potential = n.value;
                l = m +1;
            }
            else {
                r = m - 1;
            }
        }
        return potential;
    }
}
