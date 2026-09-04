class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int len = arr.size();
        int currentSum = 0;
        for(int i=0;i<m;i++) {
            
            currentSum += arr.get(i);
        }
        
        int max = currentSum;
        
        for(int i=m;i<len+m;i++) {
            currentSum = currentSum + arr.get(i%len) - arr.get((i-m)%len);
            max = Math.max(max, currentSum);
        }
        
        return max;
    }
}