class Node {
    int val;
    int count;

    public Node (int val, int count) {
        this.val = val;
        this.count = count;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }        

    PriorityQueue<Node> maxHeap = new PriorityQueue<>((a, b) -> b.count - a.count);
    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
        Node n = new Node(e.getKey(), e.getValue());
        maxHeap.add(n);
    }

    int[] out = new int[k];
    for(int i = k-1; i >= 0; i--) {
        out[i] = maxHeap.poll().val;
    }

    return out;
    }

}
