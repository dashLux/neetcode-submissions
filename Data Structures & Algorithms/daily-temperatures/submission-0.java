class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Arrays.fill(res, 0);

        Stack<Pair<Integer, Integer>> monoStack = new Stack(); // (temperature, index)

        for(int i = 0; i < temperatures.length; i++) {
            if (i == 0) {
                monoStack.push(new Pair(temperatures[i], i));
            }
            else {
                while(!monoStack.isEmpty() && temperatures[i] > monoStack.peek().getKey()) {
                    Pair<Integer, Integer> p = monoStack.pop();
                    res[p.getValue()] = i - p.getValue(); 
                }
                monoStack.push(new Pair(temperatures[i], i));
            }
        }
        return res;
    }
}
