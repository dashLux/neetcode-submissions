class Temperature {
    int temp;
    int index;

    public Temperature(int temp, int i) {
        this.temp = temp;
        this.index = i;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Temperature> monoStack = new Stack<>();
        int[] res = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            if (monoStack.isEmpty()) {
                monoStack.push(new Temperature(temperatures[i], i));
            }
            else {
                while(!monoStack.isEmpty() && monoStack.peek().temp < temperatures[i]) {
                    Temperature colder = monoStack.pop();
                    res[colder.index] = i - colder.index;
                }
                monoStack.push(new Temperature(temperatures[i], i));
            }
        }
        return res;
    }
}


//[(40, 5), (28, 6)]
