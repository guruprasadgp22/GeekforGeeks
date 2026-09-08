class Solution {
    public int maxChildren(int[] greed, int[] cookie) {
        // code here
        Arrays.sort(greed);
        Arrays.sort(cookie);
        
        int i=0;
        int j=0;
        int m = greed.length;
        int n = cookie.length;
        int count = 0;
        
        while(i < m && j < n) {
            if(cookie[j] >= greed[i]) {
                count++;
                i++;
            }
            
            j++;
        }
        
        return count;
    }
}