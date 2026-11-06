class Solution {
    public int maxPackages(int[] arr, int totalTime) {
        int n = arr.length;
        int maxEle = 0;
        for(int i=0;i<totalTime && i < n;i++) {
            maxEle += arr[i];
        }
        int max = maxEle;
        for(int i=totalTime;i<n;i++) {
            maxEle += arr[i] - arr[i - totalTime];
            max = Math.max(max, maxEle);
        }
        return max;
    }
}