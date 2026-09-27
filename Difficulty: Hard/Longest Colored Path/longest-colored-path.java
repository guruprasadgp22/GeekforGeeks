import java.util.*;

class Solution {
    public int longestPath(String s, int[][] edges) {
        int n = s.length();
        if (n == 1) return 1;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] parent = new int[n + 1];
        int[] order = new int[n];
        boolean[] visited = new boolean[n + 1];
        int idx = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order[idx++] = u;
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    queue.add(v);
                }
            }
        }

        int[] monoDown = new int[n + 1];
        int[] down = new int[n + 1];
        int ans = 1;
        char[] colors = s.toCharArray(); // colors[i] -> node i+1

        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            char cu = colors[u - 1];
            int m1 = 0, m2 = 0, childOfM1 = -1;
            int D1 = 0;
            int bestDiff = 0;

            for (int c : adj.get(u)) {
                if (c == parent[u]) continue;
                char cc = colors[c - 1];
                if (cc == cu) {
                    int md = monoDown[c];
                    if (md > m1) { m2 = m1; m1 = md; childOfM1 = c; }
                    else if (md > m2) { m2 = md; }
                    if (down[c] > D1) D1 = down[c];
                } else {
                    if (monoDown[c] > bestDiff) bestDiff = monoDown[c];
                }
            }

            int candidate1 = 1 + m1 + m2;
            int candidate2 = 1 + m1 + bestDiff;

            int maxPairSum = 0;
            for (int c : adj.get(u)) {
                if (c == parent[u]) continue;
                char cc = colors[c - 1];
                if (cc == cu) {
                    int useM = (c == childOfM1) ? m2 : m1;
                    int sum = down[c] + useM;
                    if (sum > maxPairSum) maxPairSum = sum;
                }
            }
            int candidate3 = 1 + maxPairSum;

            monoDown[u] = 1 + m1;
            down[u] = 1 + Math.max(D1, bestDiff);

            int best = Math.max(candidate1, Math.max(candidate2, candidate3));
            if (best > ans) ans = best;
        }

        return ans;
    }
}