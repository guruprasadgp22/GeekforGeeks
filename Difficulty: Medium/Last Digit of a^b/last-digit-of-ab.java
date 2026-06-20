class Solution {
    public int getLastDigit(String a, String b) {
        if (b.equals("0")) return 1; // a^0 = 1

        int lastDigit = a.charAt(a.length() - 1) - '0';

        // Compute b % 4
        int expMod4 = 0;
        for (char c : b.toCharArray()) {
            expMod4 = (expMod4 * 10 + (c - '0')) % 4;
        }

        if (expMod4 == 0) expMod4 = 4;

        int ans = 1;
        for (int i = 0; i < expMod4; i++) {
            ans = (ans * lastDigit) % 10;
        }

        return ans;
    }
}