class Solution {
    public int maximumSubarray(int[] arr) {
        long noSq = arr[0];
        long sq = (long) arr[0] * arr[0];
        long ans = Math.max(noSq, sq);

        for (int i = 1; i < arr.length; i++) {
            long x = arr[i];
            long newNoSq = Math.max(x, noSq + x);
            long newSq = Math.max(x * x, Math.max(noSq + x * x, sq + x));
            noSq = newNoSq;
            sq = newSq;
            ans = Math.max(ans, Math.max(noSq, sq));
        }
        return (int) ans;
    }
}