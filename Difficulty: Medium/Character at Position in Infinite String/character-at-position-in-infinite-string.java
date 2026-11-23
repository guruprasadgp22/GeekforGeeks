class Solution {
    public char posInfinite(String s, int pos) {
        long[] len = new long[64];
        len[0] = s.length();
        int k = 0;
        while (len[k] < pos) {                 // find the first level that covers pos
            len[k + 1] = 2 * len[k] + (k + 1);
            k++;
        }

        long p = pos;
        while (k > 0) {
            long m = len[k - 1];
            if (p <= m) {
                // in the left copy: same position, one level down
            } else if (p <= m + k) {
                return '$';                    // in the block of k dollars
            } else {
                p = 2 * m + k + 1 - p;         // mirror into the left copy
            }
            k--;
        }
        return s.charAt((int) p - 1);
    }
}