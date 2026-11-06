class Solution {
	public static int findCheapestCost(int n, int[][] edges, int src, int dst, int k) {
		List<List<int[]>> adj = new ArrayList<>();
		for (int i = 0; i<n; i++) {
			adj.add(new ArrayList<>());
		}
		
		for (int[] x: edges) {
			int u = x[0];
			int v = x[1];
			int w = x[2];
			adj.get(u).add(new int[] {v, w});
		}
		
		int[][] distance = new int[n][k + 2];
		for (int[] x: distance) {
			Arrays.fill(x, Integer.MAX_VALUE);
		}
		
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
			return Integer.compare(a[1], b[1]);
		});
		
		queue.add(new int[] {src, 0, 0});
		distance[src][0] = 0;
		
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int node = temp[0];
			int weight = temp[1];
			int count = temp[2];
			
			if (weight > distance[node][count]) {
				continue;
			}
			
			if (node == dst) {
				return weight;
			}
			
			for (int[] next: adj.get(node)) {
				int nextNode = next[0];
				int nextWeight = next[1];
				
				int newCount = count + 1;
				if (newCount > k+1) {
					continue;
				}
				
				int newWeight = nextWeight + weight;
				if (newWeight < distance[nextNode][newCount]) {
					distance[nextNode][newCount] = newWeight;
					queue.add(new int[] {nextNode, newWeight, newCount});
				}
			}
		}
		return - 1;
	}
}
