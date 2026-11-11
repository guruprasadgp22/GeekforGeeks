class Solution {
    public int subarrayXor(int[] arr) {
        long xor = 0;
        long n = arr.length;
        for(int i=0;i<n;i++) {
            long count = (i+1) * (n-i);
            if(count % 2 == 1) {
                xor ^= (long)arr[i];
            }
        }
        
        return (int)xor;
    }
}