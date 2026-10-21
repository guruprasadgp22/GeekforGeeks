class Solution {
    public int minSubarraySum(int[] arr) {
        int curr = 0;
        int res = Integer.MAX_VALUE;
        for(int ele: arr) {
            curr += ele;
            res = Math.min(res, curr);
            curr = Math.min(0, curr);
        }
        return res;
    }
}