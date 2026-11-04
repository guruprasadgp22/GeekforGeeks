class Solution {
    public int subarrayXor(int[] arr) {
        int n = arr.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            long count = (long) (i + 1) * (n - i);   // long: can reach ~2.5 × 10^9
            if (count % 2 == 1) {
                result ^= arr[i];
            }
        }
        return result;
    }
}