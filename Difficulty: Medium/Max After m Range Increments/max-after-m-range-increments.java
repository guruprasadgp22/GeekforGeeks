class Solution {
    public int findMax(int n, int[] a, int[] b, int[] k) {
        // code here
       int[] diff = new int[n];
       for(int i=0;i<a.length;i++) {
           diff[a[i]] += k[i];
           
           if(b[i] + 1 < n) {
               diff[b[i]+1] -= k[i];
           }
       }
       
       int curr = 0;
       int max = 0;
       
       for(int ele: diff) {
           curr += ele;
           max = Math.max(max, curr);
       }
       
       return max;
    }
}
