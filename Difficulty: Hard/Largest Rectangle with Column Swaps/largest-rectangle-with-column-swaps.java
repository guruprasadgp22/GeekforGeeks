class Solution {
    public int maxArea(int[][] mat) {
       int m = mat.length;
       int n = mat[0].length;
       int[] height = new int[n];
       
       int area = 0;
       
       for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j] == 1) {
                    height[j] = height[j] + 1;
                } else {
                    height[j] = 0;
                }
            }
           
            int[] temp = height;
           
            temp = Arrays
                    .stream(temp)
                    .boxed()
                    .sorted(Collections.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();
       
            for(int k=0;k<n;k++) {
                int ar = temp[k] * (k - 0 + 1);
                area = Math.max(area, ar);
            }
       }

       return area;
        
    }
}

// 0 1 1 0 0
// 1 1 1 0 1
// 1 1 1 0 1
// 1 1 1 1 1