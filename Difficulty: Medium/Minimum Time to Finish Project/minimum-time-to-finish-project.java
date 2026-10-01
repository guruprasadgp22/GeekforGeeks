import java.util.*;

class Solution {
    public int minTime(int[] duration, int[][] dependencies) {
        int n = duration.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        int[] indegree = new int[n];

        for (int[] dep : dependencies) {
            int u = dep[0], v = dep[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        int[] finishTime = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                finishTime[i] = duration[i];
                queue.add(i);
            }
        }

        int processedCount = 0;
        int ans = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            processedCount++;
            ans = Math.max(ans, finishTime[u]);

            for (int v : adj.get(u)) {
                finishTime[v] = Math.max(finishTime[v], finishTime[u] + duration[v]);
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        if (processedCount != n) {
            return -1; // cycle detected
        }

        return ans;
    }
}