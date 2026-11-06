class Solution {
	public int cntSubsets(int arr[], int l, int r) {
		int n = arr.length;
		int MOD = 1_000_000_007;
		int[] freq = new int[n + 1];
		int[] power = new int[n + 1];
		Arrays.fill(power, 1);
		for (int ele: arr) {
			freq[ele]++;
		}
		
		for (int i = 1; i <= n; i++) {
			power[i] = (power[i - 1] * 2)%MOD;
		}
		
		long currProduct = 1;
		long cum = 0;
		long ans = 0;
		
		for (int k = 0; k <= n; k++) {
			cum += freq[k];
			if (k >= l && k <= r) {
				long ways = (currProduct * power[(int)(n - cum)]) % MOD;
				ans = (ans + ways) % MOD;
			}
			currProduct = (currProduct * (power[freq[k]] - 1 + MOD) % MOD) % MOD;
		}
		
		return (int)ans;
	}
}
