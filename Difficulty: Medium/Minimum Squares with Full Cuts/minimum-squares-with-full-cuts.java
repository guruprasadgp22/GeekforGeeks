class Solution {
    public int minSquares(int n, int m) {
        int min = Math.min(n, m);
        int max = Math.max(n, m);
        int count = 0;
        while(min > 0 && max > 0) {
            count += max /min;
            int rem = max % min;
            max = Math.max(min, rem);
            min = Math.min(min, rem);
        }
        return count;
    }
}