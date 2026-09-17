class Solution {
    public static int maxDepth(String s) {
        // code here
        int curr = 0;
        int max = 0;
        
        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                curr++;
            } else if(ch ==')'){
                max = Math.max(curr, max);
                curr--;
            }
        }
        
        return max;
    }
}
