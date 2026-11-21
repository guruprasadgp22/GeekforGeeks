class Solution {
	public int smallestSubWithSum(int[] arr, int x) {
		int left = 0;
		int curr = 0;
		int maxLen = Integer.MAX_VALUE;
		
		for (int right = 0; right < arr.length; right++) {
			curr += arr[right];
			
			while (left <= right && curr > x) {
			    maxLen = Math.min(maxLen, right - left + 1);
				curr -= arr[left];
				left++;
			}
			
			
			
		}
		return maxLen == Integer.MAX_VALUE? 0: maxLen;
	}
}
