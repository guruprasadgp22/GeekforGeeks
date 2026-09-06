class Solution {
    public long pairAndSum(int[] arr) {
        long result = 0;
        
        for(int i=0;i<32;i++) {
            long k = 0;
            for(int j=0;j<arr.length;j++) {
                if((arr[j] & 1 << i) != 0) {
                    k++;
                }
            }
            
            result += (1 << i) * (k * (k-1)/2);
        }
        return result;
    }
}