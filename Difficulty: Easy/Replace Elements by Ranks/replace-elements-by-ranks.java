class Solution {
    public void replaceWithRank(int[] arr) {
        int n = arr.length;
        int[][] temp = new int[n][2];
        for(int i=0;i<n;i++) {
            temp[i][0] = arr[i];
            temp[i][1] = i;
        }
        
        Arrays.sort(temp, (a, b) -> {
            return a[0] - b[0];
        });
        
        for(int i=0;i<n;i++) {
            int index = temp[i][1];
            arr[index] = i;
        }
    }
}