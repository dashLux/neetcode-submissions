class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        int curr = n;
        while (curr != 1) {
            curr = sum(curr);
            if (seen.contains(curr)) {
                return false;
            }
            seen.add(curr);
        }
        return true;
        
    }

    public int sum(int n) {
        int sum = 0;
        while (n > 0) {
            System.out.println(n);
            int digit = n%10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
