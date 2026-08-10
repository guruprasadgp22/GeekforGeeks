class Solution {
    public long countFriendsPairings(int n) {
        return solve(n);
    }
    
    private int solve(int n) {
        if(n == 1|| n == 2) {
            return n;
        } else {
            return solve(n-1) + (n-1) * solve(n-2);
        }
    }
}