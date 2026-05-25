class Solution {
    public void sortInWave(int arr[]) {
        int n = arr.length;
        Arrays.sort(arr);
          
        for(int i=0;i<n-1;i+=2) {
            swap(arr, i, i+1);
        }
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
