class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        if(arr.length == 0) {
            return 0;
        }
        
        Arrays.sort(arr);
        
        int max = 0;
        int count = 1;
        
        for(int i=0;i<arr.length-1;i++) {
            if(arr[i] == arr[i+1]) {
                continue;
            }
            
            if(arr[i]+1 == arr[i+1]) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 1;
            }
        }
        
        return Math.max(count, max);
    }
}