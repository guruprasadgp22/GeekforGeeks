class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
        // code here
        int n = mat.length;
        
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0;i<n;i++) {
            ArrayList<Integer> ans = new ArrayList<>();
            for(int x: mat[i]) {
                ans.add(x);
            }
            
            result.add(ans);
        }
        
        return result;
    }
}