class Solution {
    public boolean isBalanced(String s) {
        // code here
        Stack<Character> stack = new Stack<>();
        int i = 0;
        
        while(i < s.length()) {
            char ch = s.charAt(i);
            
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.add(ch);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                
                if((ch == ')' && stack.peek() == '(') ||
                    (ch == '}' && stack.peek() == '{') ||
                    (ch == ']' && stack.peek() == '[' )) {
                        stack.pop();
                    } else {
                        return false;
                    }
            }
            
            i++;
        }
        
        return stack.isEmpty();
    }
}
