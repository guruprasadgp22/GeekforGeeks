class Solution {
    static String decodedString(String s) {
        // code here
        int k = 0;
        StringBuilder curr = new StringBuilder();
        Stack<Integer> num = new Stack<>();
        Stack<StringBuilder> stack = new Stack<>();
        
        for(char ch: s.toCharArray()) {
            if(Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if(ch == '[') {
                num.add(k);
                stack.add(curr);
                curr = new StringBuilder();
                k = 0;
            } else if(ch == ']') {
                StringBuilder decode = stack.pop();
                int n = num.pop();
                for(int i=0;i<n;i++) {
                    decode.append(curr);
                }
                
                curr = decode;
            } else {
                curr.append(ch);
            }
        }
        
        return curr.toString();
    }
}