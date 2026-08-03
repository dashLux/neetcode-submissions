// k -> value, timestamp
class Node {
    String value;
    int time;

    public Node(String value, int time) {
        this.value = value;
        this.time = time;
    }
}

class TimeMap {
    Map<String, List<Node>> map;

    public TimeMap() {
        this.map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, v-> new ArrayList<>()).add(new Node (value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Node> nodes = map.get(key);
        if (nodes == null || nodes.size() == 0) {
            return "";
        }

        int left = 0;
        int right = nodes.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nodes.get(mid).time <= timestamp) {
                result = nodes.get(mid).value;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return result;
    }
}
