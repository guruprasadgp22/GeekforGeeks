class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        // code here
        if(x == 0) {
            return true;
        }
        
        if(s > x) {
            return false;
        }
        
        ArrayList<Long> numbers = new ArrayList<>();
        numbers.add((long)s);
        long currentSum = s;
        
        for(int num: arr) {
            long newNum = num + currentSum;
            
            if(newNum > x) {
                break;
            }
            
            numbers.add(newNum);
            currentSum += newNum;
        }
        
        int target = x;
        for(int i=numbers.size()-1;i>=0;i--) {
            if(numbers.get(i) <= target) {
                target -= numbers.get(i);
            }
        }
        
        return target == 0;
    }
}