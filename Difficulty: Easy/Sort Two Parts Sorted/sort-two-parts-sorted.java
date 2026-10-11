class Solution {
    public void mergeTwoParts(int[] arr) {
        int n = arr.length;
        int j = 0;
        while(j+1 < n && arr[j] <= arr[j+1]) {
            j++;
        }
        
        j++;
        
        if(j == n) {
            return;
        }
        int m = j;
        int i = 0;
        int[] res = new int[n];
        int k = 0;
        while(i < m &&  j < n) {
            if(arr[i] < arr[j]) {
                res[k++] = arr[i++];
            } else {
                res[k++] = arr[j++];
            }
        }
        
        while(i < m) {
            res[k++]=arr[i++];
        }
        
        while(j < n) {
            res[k++] = arr[j++];
        }
        
        for(i=0;i<n;i++) {
            arr[i] = res[i];
        }
        
    }
}