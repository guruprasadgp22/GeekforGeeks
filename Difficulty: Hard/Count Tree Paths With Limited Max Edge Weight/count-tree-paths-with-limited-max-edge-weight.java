class Solution {
	int[] parent;
	int[] rank;
	int[] size;
	public ArrayList<Integer> maximumWeight(int n, int[][] edges, int[] queries) {
		parent = new int[n + 1];
		rank = new int[n + 1];
		size = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
		
		Arrays.sort(edges, (a, b) -> {
			return Integer.compare(a[2], b[2]);
		});
		
		int q = queries.length;
		int[][] query = new int[q][2];
		for (int i = 0; i<q; i++) {
			query[i][0] = queries[i];
			query[i][1] = i;
		}
		
		Arrays.sort(query, (a, b) -> {
			return Integer.compare(a[0], b[0]);
		});
		int[] ans = new int[q];
		
		int j = 0;
		int paths = 0;
		for (int i = 0; i<q; i++) {
			int w = query[i][0];
			int idx = query[i][1];
			while (j < edges.length && edges[j][2] <= w) {
				paths += union(edges[j][0], edges[j][1]);
				j++;
			}
			ans[idx] = paths;
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		for (int ele: ans) {
			result.add(ele);
		}
		
		return result;
	}
	
	private int union(int x, int y) {
		int parentX = find(x);
		int parentY = find(y);
		
		if (parentX == parentY) {
			return 0;
		}
		
		int paths = size[parentX] * size[parentY];
		if (rank[parentX] == rank[parentY]) {
			parent[parentY] = parentX;
			rank[parentX]++;
			size[parentX] += size[parentY];
		} else if (rank[parentX] > rank[parentY]) {
			parent[parentY] = parentX;
			size[parentX] += size[parentY];
		} else {
			parent[parentX] = parentY;
			size[parentY] += size[parentX];
		}
		return paths;
	}
	
	private int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		
		return find(parent[x]);
	}
};
