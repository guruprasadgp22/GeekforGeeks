class Solution {
    public int getMinimumDays(String s, int[] p) {
        char[] arr = s.toCharArray();
        int sameChar = 0;
        for(int i=0;i<arr.length-1;i+=1) {
            if(arr[i] == arr[i+1]) {
                sameChar++;
            }
        }

        if(sameChar == 0) {
            return 0;
        }
        
        int count = 0;
        for(int i=0;i<p.length;i++) {
            int idx = p[i];
            if(idx - 1 >= 0 && arr[idx] == arr[idx-1]) {
                sameChar--;
            } 
            if(idx + 1 < p.length && arr[idx] == arr[idx + 1]) {
                sameChar--;
            }
            count++;
            arr[idx] = '?';
            
            if(sameChar == 0) {
                return count;
            }
        }
        
        return -1;
    }
}