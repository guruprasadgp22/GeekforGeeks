class Solution {
    public int solve(int n, String s) {
        int[] state = new int[26];
        int ans = 0;
        int computers = n;
        
        for(char ch: s.toCharArray()) {
            int index = ch - 'A';
            
            if(state[index] == 0) {
                if(computers > 0) {
                    computers--;
                    state[index] = 1;
                } else {
                    state[index] = 2;
                    ans++;
                }
            } else if(state[index] == 1) {
                computers++;
                state[index] = 0;
            } else {
                state[index] = 0;
            }
        }
        
        return ans;
    }
}