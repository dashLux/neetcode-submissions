class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();

        for(String token : tokens) {
            try {
                int num = Integer.parseInt(token);
                stack.push(num);
            } catch (NumberFormatException e) {
                // operator
                if (token.equals("+")) {
                    int operand1 = stack.pop();
                    int operand2 = stack.pop();
                    stack.push(operand1 + operand2);
                }
                else if (token.equals("-")) {
                    int operand1 = stack.pop();
                    int operand2 = stack.pop();
                    stack.push(operand2 - operand1);
                }
                else if (token.equals("*")) {
                    int operand1 = stack.pop();
                    int operand2 = stack.pop();
                    stack.push(operand1 * operand2);
                }
                else {
                    int operand1 = stack.pop();
                    int operand2 = stack.pop();
                    stack.push(operand2 / operand1);
                }
            }
        }

        return stack.peek();
    }
}
