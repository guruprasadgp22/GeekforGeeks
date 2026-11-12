class Solution {
    public int minTime(int n, int s1, int s2) {
        int high = Math.max(s1, s2) * n;
        int low = 0;
        int ans = high;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            int count = mid/s1 + mid/s2;
            if(count >= n) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}