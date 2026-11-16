class Solution {
    public int findKthSmall(int[] arr, int k) {
        int n = arr.length + k;
        HashSet<Integer> set = new HashSet<>();
        for(int ele: arr) {
            set.add(ele);
        }
        
        for(int i=1;i<=n;i++) {
            if(set.contains(i)) {
                continue;
            } else {
                k--;
                if(k == 0) {
                    return i;
                }
            }
        }
        
        return -1;
    }
}