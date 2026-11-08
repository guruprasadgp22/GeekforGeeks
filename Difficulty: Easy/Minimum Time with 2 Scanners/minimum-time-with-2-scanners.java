class Solution {
    public int minTime(int n, int s1, int s2) {
        long low = 1;
        long high = (long) Math.min(s1, s2) * n;   // faster scanner alone
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long done = mid / s1 + mid / s2;       // documents finished by time mid
            if (done >= n) {
                ans = mid;          // mid works, try smaller
                high = mid - 1;
            } else {
                low = mid + 1;      // not enough time
            }
        }
        return (int) ans;
    }
}