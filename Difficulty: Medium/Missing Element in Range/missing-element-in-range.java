class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        // code here
        Arrays.sort(arr);
        HashSet<Integer> set = new HashSet<>();
        for(int ele: arr) {
            set.add(ele);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=low;i<=high;i++) {
            if(set.contains(i)) {
                continue;
            }
            ans.add(i);
        }
        
        return ans;
    }
}