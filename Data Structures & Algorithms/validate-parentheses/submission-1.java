class Solution {
    public boolean isValid(String s) {
        Set<Character> brackets = Set.of('(', ')', '[', ']', '{', '}');
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                }
                else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                }
                else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                }
                else {
                    stack.push(c);
                }
            }
            else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
