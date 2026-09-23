class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] L = new int[n];
        int[] R = new int[n];

        // Compute L array (left to right)
        L[0] = Math.min(arr[0], 1);
        for (int i = 1; i < n; i++) {
            L[i] = Math.min(arr[i], L[i - 1] + 1);
        }

        // Compute R array (right to left)
        R[n - 1] = Math.min(arr[n - 1], 1);
        for (int i = n - 2; i >= 0; i--) {
            R[i] = Math.min(arr[i], R[i + 1] + 1);
        }

        int maxH = 0;
        long totalSum = 0;

        // Find the maximum peak height and total sum of the array
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            int h = Math.min(L[i], R[i]);
            if (h > maxH) {
                maxH = h;
            }
        }

        // The sum of a pyramid with peak height H is H * H
        long maxPyramidSum = (long) maxH * maxH;

        return (int) (totalSum - maxPyramidSum);
    }
}