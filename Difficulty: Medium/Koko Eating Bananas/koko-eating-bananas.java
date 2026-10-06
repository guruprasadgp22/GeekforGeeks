class Solution {
    public int kokoEat(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        for(int ele: arr) {
            max = Math.max(ele, max);
        }
        
        
        return binarySearch(arr, 1, max, k);
    }
    
    private int binarySearch(int[] arr, int left, int right, int k) {
        while(left < right) {
            int mid = left + (right - left)/2;
            
            if(canEat(arr, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canEat(int[] arr, int mid, int k) {
        int h = 0;
        
        for(int ele: arr){
            h += ele/mid;
            
            if(ele % mid != 0) {
                h++;
            }
        }
        
        return h <= k;
    }
}
