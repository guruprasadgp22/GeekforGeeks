class Solution {
    public String findLongestWord(String s, List<String> d) {
        // code here
        String result = "";
        
        d.sort((a, b) -> {
            if(a.length() == b.length()) {
                return a.compareTo(b);
            }
            return b.length() - a.length();
        });
        
        for(String str: d) {
            if(subSequence(str, s)) {
                if(result.length() < str.length() || (result.length() == str.length() && str.compareTo(result) < 0)) {
                    return str;
                }
            }
        }
        
        return "";
    }
    
    private boolean subSequence(String s1, String s2) {
        int i = 0;
        int j = 0;
        
        while(i < s1.length() && j < s2.length()) {
            if(s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            j++;
        }
        
        
        return i == s1.length();
    }
}