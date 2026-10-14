class Solution {
    public String findRollOut(String s, int[] roll) {
        int n = s.length();
        int[] freq = new int[n+1];
        for(int x: roll) {
            freq[0]++;
            freq[x]--;
        }
        
        int prefixSum = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            prefixSum += freq[i];
            int curr = s.charAt(i)-'a';
            int updated = (curr + prefixSum) % 26;
            sb.append((char)('a' + updated));
        }
        return sb.toString();
    }
}