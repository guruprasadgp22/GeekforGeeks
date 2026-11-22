class Solution {
	public int longestSubarrayDivK(int[] arr, int k) {
		int n = arr.length;
		int sum = 0;
		int maxLen = 0;
		int[] lastSeen = new int[k];
		Arrays.fill(lastSeen, -10);
		lastSeen[0] = -1;
		for (int i = 0; i<n; i++) {
			sum += arr[i];
			int rem = (sum % k + k) % k;
			if(lastSeen[rem] != -10) {
			    maxLen = Math.max(maxLen, i - lastSeen[rem]);
			} else {
			    lastSeen[rem] = i;
			}
		}
		return maxLen;
	}
}
