class Solution {
    private boolean isValid(String s) {
        if(s.matches("-?\\d+")) {
            return true;
        } else {
            return false;
        }
    }
    public int evaluatePostfix(String[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(String str: arr) {
            if(isValid(str)) {
                int num = Integer.parseInt(str);
                stack.add(num);
            } else {
                char ch = str.charAt(0);
                
                int num2 = stack.pop();
                int num1 = stack.pop();
                
                if(ch == '+') {
                    int ans = num2 + num1;
                    stack.add(ans);
                } else if(ch == '-') {
                    int ans = num1 - num2;
                    stack.add(ans);
                } else if(ch == '*') {
                    int ans = num1 * num2;
                    stack.add(ans);
                } else if(ch == '/') {
                    int ans = Math.floorDiv(num1, num2);
                    stack.add(ans);
                } else if(ch == '^') {
                    int ans = (int)Math.pow(num1, num2);
                    stack.add(ans);
                }
            }
        }
        
        return stack.pop();
    }
}