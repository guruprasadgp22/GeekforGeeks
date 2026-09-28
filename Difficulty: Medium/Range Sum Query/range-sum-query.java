class SegmentTree {
    int n;
    int[] tree;
    
    SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4*n];
        buildST(0, n-1, 0, arr);
    }
    
    void buildST(int start, int end, int node, int[] arr) {
        if(start == end) {
            tree[node] = arr[start];
            return;
        }
        
        int mid = start + (end - start)/2;
        buildST(start, mid, 2*node+1, arr);
        buildST(mid+1, end, 2 *node+2, arr);
        
        tree[node] = tree[2*node+1] + tree[2*node+2];
    }
    
    int query(int start, int end, int left, int right, int node) {
        if(right < start || left > end) {
            return 0;
        }
        
        if(left <= start && right >= end) {
            return tree[node];
        }
        
        int mid = start + (end - start)/2;
        return query(start, mid, left, right, 2*node+1) + query(mid+1, end, left, right, 2*node+2);
    }
}
class Solution {
    public ArrayList<Integer> querySum(int[] arr, int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        SegmentTree st = new SegmentTree(arr);
        
        for(int[] x: queries) {
            int start = x[0];
            int end = x[1];
            
            result.add(st.query(0, arr.length-1, start-1, end-1, 0));
        }
        
        return result;
    }
}