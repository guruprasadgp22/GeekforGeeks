class Solution {
    public int countAlwaysFound(int[] arr) {
        int n = arr.length;
        int[] leftMax = new int[n];
        leftMax[0] = arr[0];
        for(int i=1;i<n;i++) {
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        }
        
        int rightMax[] = new int[n];
        rightMax[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--) {
            rightMax[i] = Math.min(rightMax[i+1], arr[i]);
        }
        
        int count = 0;
        for(int i=0;i<n;i++) {
            if(leftMax[i] <= arr[i] && arr[i] <= rightMax[i]) {
                count++;
            }
        }
        
        return count;
    }
}