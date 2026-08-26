class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens) {
            try {
                int number = Integer.parseInt(s);
                stack.push(number);
            } catch (Exception e) {
                //seeing an operand
                int op1 = stack.pop();
                int op2 = stack.pop();

                if (s.equals("+")) {
                    stack.push(op1 + op2);
                }
                else if (s.equals("*")) {
                    stack.push(op1 * op2);
                }
                else if (s.equals("-")) {
                    stack.push(op2 - op1);
                }
                else {
                    stack.push(op2 / op1);
                }
            }
        }        
        return stack.peek();
    }
}


