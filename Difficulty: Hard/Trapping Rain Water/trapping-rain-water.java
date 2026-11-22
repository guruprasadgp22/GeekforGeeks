class Solution {
    public int maxWater(int arr[]) {
        int n = arr.length;
        int[] maxLeft = new int[n];
        maxLeft[0] = arr[0];
        for(int i=1;i<n;i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], arr[i]);
        }
        
        int maxRight[] = new int[n];
        maxRight[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--) {
            maxRight[i] = Math.max(maxRight[i+1], arr[i]);
        }
        
        int total = 0;
        for(int i=1;i<n-1;i++) {
            int min = Math.min(maxLeft[i-1], maxRight[i+1]);
            if(min <= arr[i]) {
                continue;
            } else{
                total += min - arr[i];
            }
        }
        return total;
    }
}
