class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length;
        int len = n/2;
        int count = 0;
        int second[] = new int[len];
        for(int i=len;i<n;i++) {
            second[i-len] = arr[i];
        }
        
        Arrays.sort(second);
        
        for(int i=0;i<len;i++) {
            for(int j=len-1;j>=0;j--) {
                if(arr[i] >= 5 * second[j]) {
                    count += j+1;
                    break;
                }
            }
        }
        
        return count;
    }
}