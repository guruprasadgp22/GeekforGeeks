class SegmentTree {
    int n;
    int[] tree;
    
    SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4*n];
        build(0, 0, n-1, arr);
    }
    
    void build(int node, int start, int end, int[] arr) {
        if(start == end) {
            tree[node] = arr[start];
            return;
        }
        
        int mid = start + (end - start)/2;
        build(2*node+1, start, mid, arr);
        build(2*node+2, mid+1, end, arr);
        
        tree[node] = Math.min(tree[2*node+1], tree[2*node+2]);
    }
    
    int query(int node, int start, int end, int left, int right) {
        if(left > end || right < start) {
            return Integer.MAX_VALUE;
        }
        
        if(left <= start && right >= end) {
            return tree[node];
        }
        
        int mid = start + (end - start)/2;
        int leftSide = query(2*node+1, start, mid, left, right);
        int rightSide = query(2*node+2, mid+1, end, left, right);
        
        return Math.min(leftSide, rightSide);
    }
}
class Solution {
    public ArrayList<Integer> rangeMinQuery(int[] arr, int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        
        SegmentTree st = new SegmentTree(arr);
        
        for(int[] x: queries) {
            result.add(st.query(0, 0, arr.length-1, x[0], x[1]));
        }
        
        return result;
        
    }
}