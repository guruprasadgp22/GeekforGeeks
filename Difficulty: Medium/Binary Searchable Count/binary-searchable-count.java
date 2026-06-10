class Solution {
    public int binarySearchable(int[] arr) {
        // code here
        int count = 0;
        
        for(int ele: arr) {
            if(binarySearch(arr, ele)) {
                count++;
            }
        }
        
        return count;
    }
    
    public boolean binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length-1;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            
            if(arr[mid] == key) {
                return true;
            }
            
            if(arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
};