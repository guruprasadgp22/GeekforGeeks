class Solution {
	public char nthCharacter(int n) {
		long start = 1;
		long count = 9;
		long len = 1;
		
		while (n > len * count) {
			n -= len * count;
			count *= 10;
			len++;
			start *= 10;
		}
		
		long num = start + (n - 1)/len;
		int index = (int)((n - 1)%len);
		return String.valueOf(num).charAt(index);
		
	}
}
