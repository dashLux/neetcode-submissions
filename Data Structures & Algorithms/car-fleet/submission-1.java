class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Integer[]> cars = new ArrayList<>();
        for(int i = 0; i < position.length; i++) {
            cars.add(new Integer[]{position[i], speed[i]});
        }

        cars.sort(Comparator.comparingInt((Integer[] a) -> a[0]).reversed());

        Stack<Integer[]> stack = new Stack<>();

        for(Integer[] car : cars) {
            if(stack.isEmpty() || calculateTime(target, car) > calculateTime(target, stack.peek())) {
                stack.push(car);
            }
        }

        return stack.size();

    }

    public double calculateTime(int target, Integer[] car) {
        return (double)(target - car[0]) / car[1];
    }
}
