class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = val[i];
            arr[i][1] = wt[i];
        }
        
        Arrays.sort(arr, (a, b) -> {
           return Double.compare((double)b[0] / b[1], (double)a[0] / a[1]); 
        });
        
        double total = 0;
        for(int i=0;i<n;i++){
            if(capacity >= arr[i][1]) {
                total += arr[i][0];
                capacity -= arr[i][1];
            } else {
                total += ((double)arr[i][0]/arr[i][1]) * capacity;
                capacity = 0;
                break;
            }
        }
        return total;
    }
}