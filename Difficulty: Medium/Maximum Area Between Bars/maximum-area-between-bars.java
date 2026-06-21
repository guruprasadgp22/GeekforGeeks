class Solution {
    public int maxArea(List<Integer> height) {
        // code here
        int left = 0;
        int right = height.size()-1;
        int ans = 0;
        
        while(left < right) {
            int product = (right - left-1) * (Math.min(height.get(left), height.get(right)));
            ans = Math.max(ans, product);
            
            if(height.get(left) < height.get(right)) {
                left++;
            } else{
                right--;
            }
        }
        
        return ans;
    }
}