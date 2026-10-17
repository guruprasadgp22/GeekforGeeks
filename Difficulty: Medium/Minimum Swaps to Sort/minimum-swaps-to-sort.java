class Solution {
    public int minSwaps(int arr[]) {
       int n = arr.length;
       int[] temp = Arrays.copyOf(arr, n);
       Arrays.sort(temp);
       HashMap<Integer, Integer> map = new HashMap<>();
       for(int i=0;i<n;i++) {
           map.put(arr[i], i);
       }
       
       int count = 0;
       for(int i=0;i<n;i++) {
           int currVal = arr[i];
           int expVal = temp[i];
           
           if(currVal == expVal) {
               continue;
           }
           
           int idx = map.get(expVal);
           arr[i] = expVal;
           arr[idx] = currVal;
           count++;
           map.put(arr[i], i);
           map.put(arr[idx], idx);
       }
       
       return count;
    }
}