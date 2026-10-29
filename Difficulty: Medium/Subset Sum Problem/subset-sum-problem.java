class Solution {
	int n;
	int[][] dp;
	
	boolean isSubsetSum(int arr[], int sum) {
		n = arr.length;
		dp = new int[n][sum + 1];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}
		return solve(0, sum, arr);
	}
	
	private boolean solve(int i, int sum, int[] arr) {
		if (sum == 0) {
			return true;
		}
		
		if (i >= n) {
			return false;
		}
		
		if (dp[i][sum] != -1) {
			return dp[i][sum] == 1 ? true : false;
		}
		
		boolean take = false;
		if (arr[i] <= sum) {
			take |= solve(i + 1, sum - arr[i], arr);
		}
		boolean skip = solve(i + 1, sum, arr);
		dp[i][sum] = skip | take ? 1 : 0;
		return skip | take;
	}
}
