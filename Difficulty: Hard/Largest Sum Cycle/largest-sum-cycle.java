class Solution {
    public int largestSumCycle(int[] edge) {
        int n = edge.length;
        int[] mark = new int[n];          // 0 = unvisited, else walk id + 1
        long best = -1;

        for (int s = 0; s < n; s++) {
            if (mark[s] != 0) continue;
            int id = s + 1;
            int cur = s;
            while (cur != -1 && mark[cur] == 0) {
                mark[cur] = id;
                cur = edge[cur];
            }
            // Cycle found within this walk
            if (cur != -1 && mark[cur] == id) {
                long sum = cur;
                int v = edge[cur];
                while (v != cur) {
                    sum += v;
                    v = edge[v];
                }
                best = Math.max(best, sum);
            }
        }
        return (int) best;
    }
}