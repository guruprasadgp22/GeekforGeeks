class Solution {
    int[] prefixSum;
    public int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);
       
        int result = 1;
       
        int n = arr.length;
        
        prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for(int i=1;i<n;i++) {
            prefixSum[i] = arr[i] + prefixSum[i-1];
        }
        
        for(int i=0;i<n;i++) {
            int freq = binarySearch(i, arr, k);
            result = Math.max(result, freq);
        }
       
        return result;
    }
    
    private int binarySearch(int targetIdx, int[] arr, int k) {
        
        int targetEle = arr[targetIdx];
        
        int left = 0;
        int right = targetIdx;
        
        int result = targetIdx;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            int count = targetIdx - mid + 1;
            int windowSum = count * targetEle;
            int originalSum = prefixSum[targetIdx] - prefixSum[mid] + arr[mid];
            int operation = windowSum - originalSum;
            
            if(operation > k) {
                left = mid+1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }
        
        return targetIdx - result + 1;
    }
}