class Solution {
    public int firstElementKTime(int[] arr, int k) {
        int[] freq = new int[1000001];
        for(int ele: arr) {
            freq[ele]++;
            if(freq[ele] == k) {
                return ele;
            }
        }
        return -1;
    }
}