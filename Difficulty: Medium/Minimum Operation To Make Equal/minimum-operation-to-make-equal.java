class Solution {
    public int minOps(int[] arr) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int ele: arr) {
            sum += ele;
            min = Math.min(ele, min);
        }
        return sum - min * arr.length;
    }
}
