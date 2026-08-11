class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] prefix = new int[m+1][n+1];
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                prefix[i][j] = mat[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int[] query: queries) {
            int i = query[0];
            int j = query[1];
            
            int maxRadies = Math.min(
                Math.min(i, j),
                Math.min(m-i-1, n-j-1)
                );
                
            int best = -1;
            
            int low = 0;
            int high = maxRadies;
            
            while(low <= high) {
                int mid = low + (high-low)/2;
                int top = i - mid;
                int bottom = i + mid;
                int left = j - mid;
                int right = j + mid;
                
                int ones = prefix[bottom+1][right+1] - prefix[top][right+1] - prefix[bottom+1][left] + prefix[top][left];
                
                if(ones <= k) {
                    best = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            
            if(best == -1) {
                result.add(-1);
            } else {
                result.add(2 * best + 1);
            }
            
        }
        
        return result;
    }
}