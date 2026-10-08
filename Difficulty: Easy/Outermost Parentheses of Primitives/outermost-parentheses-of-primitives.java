class Solution {
    public String removeOuter(String s) {
        int count = 0;
        StringBuilder curr = new StringBuilder();
        
        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                if(count > 0) {
                    curr.append(ch);
                }
                count++;
            } else {
                if(count > 1) {
                    curr.append(ch);
                }
                count--;
            }
        }
        
        return curr.toString();
    }
}