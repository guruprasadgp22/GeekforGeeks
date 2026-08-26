class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;

        int[] pos = new int[n+1];
        for(int i=0;i<n;i++) {
            pos[arr[i]] = i;
        }

        // for(int ele: pos) {
        //     System.out.print(ele + " ");
        // }
        // 2 1 3
        // 0, 1, 0, 3
        
        int current = 1;
        int max = 0;
        for(int i=2;i<=n;i++) {
            if(pos[i-1] < pos[i]) {
                current++;
            } else {
                max = Math.max(max, current);
                current = 1;
            }
        }
        
        
        return arr.length-Math.max(max, current);
    }
}