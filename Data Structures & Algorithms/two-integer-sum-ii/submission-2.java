/**
    **INPUT IS SORTED**

    - fixing 1 element, and binary search the rest element to find target - fixed element 
     is going to be actually O(nlgn) because worst case need to perform n binary search 
     where n is the length of the array


     - two-pointer, left and right being on both ends of the array, and compute
     nums[left] + nums[right]. If sum is greater than target, do right--, if sum is less
     than target, do left++. This is O(n) time and O(1) space solution.
*/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if (target == sum) {
                return new int[]{left+1, right+1};
            }
            if (target < sum) {
                right--;
            }
            else {
                left++;
            }
        }    
        return new int[0];    
    }
}
