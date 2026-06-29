class Solution {
    public static int findEquilibrium(int arr[]) {
        // code here
        int n = arr.length;
        int prefixSum[] = new int[n+1];
        int sum = 0;
        prefixSum[0] = 0;
        
        for(int i=1;i<n;i++) {
            sum += arr[i-1];
            prefixSum[i] = sum;
        }
        
        sum = 0;
        int[] suffixSum = new int[n+1];
        suffixSum[n] = 0;
        
        for(int i=n-2;i>=0;i--) {
            sum += arr[i+1];
            suffixSum[i] = sum;
        }
        
        for(int i=0;i<n;i++) {
            if(suffixSum[i] == prefixSum[i]) {
                return i;
            }
        }
        
        return -1;
    }
}
