class Solution {
    char[][] num = {{}, {},
                    {'a', 'b', 'c'},
                    {'d', 'e', 'f'},
                    {'g', 'h', 'i'},
                    {'j', 'k', 'l'},
                    {'m', 'n', 'o'},
                    {'p', 'q', 'r', 's'},
                    {'t', 'u', 'v'},
                    {'w', 'x', 'y', 'z'}};
    ArrayList<String> result;
    public ArrayList<String> possibleWords(int[] arr) {
        // code here
        result = new ArrayList<>();
        ArrayList<String> curr = new ArrayList<>();
        curr.add("");
        solve(0, curr, arr);
        return result;
    }
    
    private void solve(int i, ArrayList<String> curr, int[] arr) {
        if(i == arr.length) {
            result.addAll(curr);
            return;
        }
        
        if(arr[i] == 0 || arr[i] == 1) {
            solve(i+1, curr, arr);
        }
        
        ArrayList<String> ans = new ArrayList<>();
        for(String s: curr) {
            for(char ch: num[arr[i]]) {
                ans.add(s+String.valueOf(ch));
            }
        }
        
        solve(i+1, ans, arr);
    }
}