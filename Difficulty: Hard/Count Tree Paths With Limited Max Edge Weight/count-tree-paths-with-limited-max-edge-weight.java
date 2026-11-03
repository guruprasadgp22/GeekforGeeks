class Solution {
    int[] par, sz;

    int find(int x) {
        while (par[x] != x) {
            par[x] = par[par[x]];      // path compression (iterative, no recursion)
            x = par[x];
        }
        return x;
    }

    public ArrayList<Integer> maximumWeight(int n, int[][] edges, int[] queries) {
        par = new int[n + 1];          // nodes are 1..n
        sz = new int[n + 1];
        for (int i = 1; i <= n; i++) { par[i] = i; sz[i] = 1; }

        int[][] es = edges.clone();
        Arrays.sort(es, (a, b) -> Integer.compare(a[2], b[2]));

        int q = queries.length;
        Integer[] order = new Integer[q];
        for (int i = 0; i < q; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> Integer.compare(queries[a], queries[b]));

        int[] res = new int[q];
        long paths = 0;
        int e = 0;

        for (int idx : order) {
            while (e < es.length && es[e][2] <= queries[idx]) {
                int a = find(es[e][0]), b = find(es[e][1]);
                if (a != b) {
                    paths += (long) sz[a] * sz[b];               // new paths across the two parts
                    if (sz[a] < sz[b]) { int t = a; a = b; b = t; }
                    par[b] = a;                                  // union by size
                    sz[a] += sz[b];
                }
                e++;
            }
            res[idx] = (int) paths;                              // store in original position
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int x : res) ans.add(x);
        return ans;
    }
}