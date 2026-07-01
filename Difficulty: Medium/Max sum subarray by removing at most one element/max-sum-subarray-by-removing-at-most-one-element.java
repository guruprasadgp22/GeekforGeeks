class Solution {
    public int maxSumSubarray(int[] arr) {

        int keep = arr[0];
        int delete = Integer.MIN_VALUE;
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int newKeep = Math.max(arr[i], keep + arr[i]);

            int newDelete;
            if (delete == Integer.MIN_VALUE) {
                newDelete = keep;           // delete current element
            } else {
                newDelete = Math.max(keep, delete + arr[i]);
            }

            keep = newKeep;
            delete = newDelete;

            ans = Math.max(ans, Math.max(keep, delete));
        }

        return ans;
    }
}