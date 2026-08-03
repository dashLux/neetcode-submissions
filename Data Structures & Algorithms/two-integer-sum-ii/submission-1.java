class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //fix 1 element, then binary search the rest

        for(int i = 0; i < numbers.length; i++) {
            int res = binarySearch(numbers, i+1, target - numbers[i]);
            if (res != -1) {
                int[] out = new int[] {i+1, res+1};
                return out;
            }
        }
        return new int[2];
    }

    public int binarySearch(int[] numbers, int start, int target) {
        int left = start;
        int right = numbers.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (numbers[mid] == target) {
                return mid;
            }
            else if (numbers[mid] < target) {
                left = mid +1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
