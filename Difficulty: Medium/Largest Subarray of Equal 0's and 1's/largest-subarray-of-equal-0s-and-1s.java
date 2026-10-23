class Solution {
    public int maxLen(int[] arr) {
        int currSum = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0;i<arr.length;i++) {
            currSum += arr[i] == 1? 1: -1;
            if(map.containsKey(currSum)) {
                int len = i - map.get(currSum);
                maxLen = Math.max(maxLen, len);
            } else {
                map.put(currSum, i);
            }
        }
        
        return maxLen;
    }
}