class Solution {
    public ArrayList<Integer> lexicographicallyLargest(int[] arr) {
        int n = arr.length;
        int i = 0;
        
        while(i < n) {
            int j = i;
            
            while(i+1 < n && arr[i] % 2 == arr[i+1] % 2) {
                i++;
            }
            
            Arrays.sort(arr, j, i+1);
            int start = j;
            int end = i;
            
            while(start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
            
            i++;
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int ele: arr) {
            result.add(ele);
        }
        return result;
    }
}