class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        int xor = 0;
        for(int[] ele: queries) {
            int x = ele[0];
            int val = ele[1];
            
            if(x == 0) {
                ans.add(val ^ xor);
            } else {
                xor ^= val;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int ele: ans) {
            result.add(ele ^ xor);
        }
        
        result.sort((a, b) -> {
            return a - b;
        });
        
        return result;
    }
}