class SegmentTree {
    int n;
    int[] tree;
    
    SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        buildST(0, n-1, 0, arr);
    }
    
    
    void buildST(int start, int end, int node, int[] arr) {
        if(start == end) {
            tree[node] = arr[start];
            return;
        }
        
        int mid = start + (end - start)/2;
        buildST(start, mid, 2*node+1,arr);
        buildST(mid+1, end, 2 *node+2, arr);
        
        tree[node] = GCD(tree[2*node+1], tree[2*node+2]);
    }
    
    int GCD(int a, int b) {
        while(b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        
        return a;
    }
    
    void update(int start, int end, int node, int index, int val) {
        if(start == end) {
            tree[node] = val;
            return; 
        }
        
        int mid = start + (end - start)/2;
        if(index <= mid) {
            update(start, mid, 2*node+1, index, val);
        } else {
            update(mid+1, end, 2 *node+2, index, val);
        }
        
        tree[node] = GCD(tree[2*node+1], tree[2*node+2]);
    }
    
    int query(int start, int end, int left, int right, int node) {
        if(right < start || left > end) {
            return  0;
        }
        
        if(left <= start && right >= end) {
            return tree[node];
        }
        
        int mid = start + (end - start)/2;
        int gcd1 = query(start, mid, left, right, 2*node+1);
        int gcd2 = query(mid+1, end, left, right, 2*node+2);
        if(gcd1 == 0) {
            return gcd2;
        }
        
        if(gcd2 == 0) {
            return gcd1;
        }
        
        return GCD(gcd1, gcd2);
    }
}

class Solution {
    public ArrayList<Integer> processQueries(int[] arr, int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        SegmentTree st = new SegmentTree(arr);
        
        for(int[] x: queries) {
            if(x[0] == 0) {
                int left = x[1];
                int right = x[2];
                result.add(st.query(0, arr.length-1, left, right, 0));
            } else {
                int index = x[1];
                int value = x[2];
                st.update(0, arr.length-1, 0, index, value);
            }
        }
        
        return result;
    }
}