class Solution {
    public int closest3Sum(int[] arr, int target) {
        Arrays.sort(arr);
        int closest = 0;
        int diff = Integer.MAX_VALUE;
        int n = arr.length;
        
        for(int i=0;i<n;i++) {
            int j= i+1;
            int k = n-1;
            
            while(j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                int d = Math.abs(sum - target);
                if(d == diff) {
                    closest = Math.max(closest, sum);
                } else if(d < diff) {
                    diff = d;
                    closest = sum;
                }
                
                if(sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return closest;

    }
}