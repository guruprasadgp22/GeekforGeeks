class Solution {
    public int countSubarray(int[] arr, int l, int r) {
        // code here
         return sum(arr, r)-sum(arr,l-1);
    }
    
    private int sum(int[] arr, int sum) {
        int count = 0;
        
        int left = 0;
        int currSum = 0;
        for(int right=0;right < arr.length;right++) {
            currSum += arr[right];
            while(currSum > sum && left <= right) {
                currSum -= arr[left];
                left++;
            }
            count += right-left+1;
        }
        
        // System.out.println(count);
        return count;
    }
}