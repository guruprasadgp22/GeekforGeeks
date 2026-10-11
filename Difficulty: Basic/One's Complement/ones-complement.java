class Solution {
    static int onesComplement(int n) {
        int bitCount = (int)(Math.log(n)/Math.log(2)) + 1;
        int xor = (1 << bitCount) - 1;
        return xor - n;

    }
}