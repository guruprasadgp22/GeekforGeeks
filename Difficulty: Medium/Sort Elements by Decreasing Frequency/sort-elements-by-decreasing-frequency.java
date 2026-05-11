// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int ele: arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        
        Integer[] ans = new Integer[arr.length];
        for(int i=0;i<arr.length;i++) {
            ans[i] = arr[i];
        }
        
        Arrays.sort(ans, (a, b) -> {
           int freq1 = map.get(a);
           int freq2 = map.get(b);
           
           if(freq1 != freq2) {
               return freq2 - freq1;
           }
           return a - b;
        });
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<ans.length;i++) {
            list.add(ans[i]);
        }
        
        return list;
        
    }
}