class Solution {
    ArrayList<String> result;
    public ArrayList<String> generateParentheses(int n) {
        // code here
        result = new ArrayList<>();
        solve(0, 0, new StringBuilder(), n);
        return result;
    }
    
    private void solve(int open, int close, StringBuilder curr, int n){
        if(curr.length() == n) {
            result.add(curr.toString());
            return;
        }
        
        if(open < n/2) {
            curr.append("(");
            solve(open+1, close, curr, n);
            curr.deleteCharAt(curr.length()-1);
        }
        
        if(close < open) {
            curr.append(")");
            solve(open, close+1, curr, n);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}