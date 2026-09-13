class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        if (n <= 1) return 0;

        // Step 1: Find the farthest node from an arbitrary node (0)
        int[] firstBFS = bfs(0, n, adj);
        int u = firstBFS[0];

        // Step 2: Find the farthest node from u to get the tree diameter
        int[] secondBFS = bfs(u, n, adj);
        int diameter = secondBFS[1];

        // Step 3: Return the radius ceil(diameter / 2)
        return (diameter + 1) / 2;
    }

    private int[] bfs(int start, int n, ArrayList<ArrayList<Integer>> adj) {
        int[] dist = new int[n];
        java.util.Arrays.fill(dist, -1);

        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        queue.add(start);
        dist[start] = 0;

        int farthestNode = start;
        int maxDist = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (dist[curr] > maxDist) {
                maxDist = dist[curr];
                farthestNode = curr;
            }

            for (int neighbor : adj.get(curr)) {
                int nextNode = neighbor - 1; // Convert 1-based house number to 0-based index
                if (dist[nextNode] == -1) {
                    dist[nextNode] = dist[curr] + 1;
                    queue.add(nextNode);
                }
            }
        }

        return new int[] { farthestNode, maxDist };
    }
}