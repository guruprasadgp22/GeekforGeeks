class Solution {
    public void sortIt(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i] % 2 == 1) {
                arr[i] *= -1;
            }
        }
        
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++) {
            if(arr[i] < 0) {
                arr[i] *= -1;
            } else {
                break;
            }
        }
    }
}
