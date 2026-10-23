
class Solution {
    public static int zeroSumSubmat(int[][] mat) {
        int n = mat.length;
        int[][] sum = new int[n+1][n+1];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                sum[i+1][j+1] = mat[i][j] + sum[i+1][j] + sum[i][j+1] - sum[i][j];
            }
        }

        int maxLen = 0;
        int res = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                for(int k=1;i+k<=n;k++) {
                    for(int l=1;l+j<=n;l++) {
                        int sm = sum[i+k][j+l]+sum[i][j] - sum[i+k][j] - sum[i][j+l];
                        if(sm == 0) {
                            int len = k * l;
                            maxLen = Math.max(maxLen, len);
                        }
                    }
                }
            }
        }
        
        return maxLen;
    }
}
