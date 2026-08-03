class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put(']', '[');
        bracketMap.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(c);
            }
            else if (stack.peek() == bracketMap.get(c)) {
                stack.pop();
            }
            else {
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }

}
