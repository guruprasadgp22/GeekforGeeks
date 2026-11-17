class Solution {
    public boolean findPattern(String s) {
         int n = s.length();
        int i = 0;

        while (i < n) {
            int cx = 0, cy = 0;
            while (i < n && s.charAt(i) == 'x') { cx++; i++; }
            while (i < n && s.charAt(i) == 'y') { cy++; i++; }

            if (cx == 0 || cx != cy) return false;   // not a valid x^n y^n block
        }
        return true;

    }
}
