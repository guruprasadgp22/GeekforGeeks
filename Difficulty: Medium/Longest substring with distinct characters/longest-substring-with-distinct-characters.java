class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int left = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            
            if(map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            
            map.put(ch, i);
            max = Math.max(max, i - left + 1);
        }
        
        return max;
    }
}