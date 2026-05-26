// User function Template for Java

class Solution {
    // Function to count the number of subarrays with a sum that is divisible by K
    public int subCount(int[] arr, int k) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        long count = 0;
        long sum = 0;
        
        for(int ele: arr) {
            sum +=(long)ele;
            
            int rem = (int)((sum % k + k) % k);
            
            if(map.containsKey(rem)) {
                count += map.get(rem);
            }
            
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        
        return (int)count;
    }
}
