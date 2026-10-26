class Solution {
	public int minDiff(int k, int[] arr) {
		int n = arr.length;
		
		int[] prefixMin = new int[n];
		int[] prefixMax = new int[n];
		prefixMin[0] = arr[0];
		prefixMax[0] = arr[0];
		for (int i = 1; i<n; i++) {
			prefixMin[i] = Math.min(prefixMin[i - 1], arr[i]);
			prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
		}
		
		int suffixMin[] = new int[n];
		int[] suffixMax = new int[n];
		suffixMin[n - 1] = arr[n - 1];
		suffixMax[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			suffixMin[i] = Math.min(suffixMin[i + 1], arr[i]);
			suffixMax[i] = Math.max(suffixMax[i + 1], arr[i]);
		}
		
		int result = Integer.MAX_VALUE;
		for (int i = 0; i <= n - k; i++) {
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			if (i - 1 >= 0) {
				min = Math.min(min, prefixMin[i - 1]);
				max = Math.max(max, prefixMax[i - 1]);
			}
			
			if (i + k < n) {
				min = Math.min(min, suffixMin[i + k]);
				max = Math.max(max, suffixMax[i + k]);
			}
			
			result = Math.min(result, max - min);
		}
		
		return result == Integer.MAX_VALUE? 0: result;
		
	}
}

// [2, 2],[2, 3],[1, 3],[1, 4], [1, 6], [1, 7]
