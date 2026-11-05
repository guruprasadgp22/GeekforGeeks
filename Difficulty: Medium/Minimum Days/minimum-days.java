class Solution {
    public int getMinimumDays(String s, int[] p) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        int bad = 0;
        for (int i = 0; i + 1 < n; i++) {
            if (arr[i] == arr[i + 1]) bad++;
        }
        if (bad == 0) return 0;                       // already valid

        for (int day = 0; day < n; day++) {
            int idx = p[day];

            if (idx > 0 && arr[idx - 1] != '?' && arr[idx - 1] == arr[idx]) bad--;
            if (idx + 1 < n && arr[idx + 1] != '?' && arr[idx + 1] == arr[idx]) bad--;

            arr[idx] = '?';
            if (bad == 0) return day + 1;             // days are 1-indexed
        }
        return n;                                     // unreachable: all '?' means no bad pairs
    }
}