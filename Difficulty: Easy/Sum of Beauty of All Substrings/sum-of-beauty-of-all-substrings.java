class Solution {
	public int beautySum(String s) {
		int total = 0;
		int n = s.length();
		
		for (int i = 0; i<n; i++) {
			int[] freq = new int[26];
			
			for (int j = i; j<n; j++) {
				freq[s.charAt(j) - 'a']++;
				int min = Integer.MAX_VALUE;
				int max = 0;
				
				for (int ele: freq) {
					if (ele == 0) {
						continue;
					}
					min = Math.min(min, ele);
					max = Math.max(ele, max);
				}
				
				total += max - min;
				
			}
			
		}
		
		return total;
	}
}
