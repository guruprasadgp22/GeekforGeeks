class Solution {
    public int numberOfSubarrays(int[] arr, int target) {
        int count = 0;
        int currSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int ele: arr) {
            currSum += ele;
            
            if(map.containsKey(currSum - target)) {
                count += map.get(currSum - target);
            }
            
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        
        return count;
    }
}