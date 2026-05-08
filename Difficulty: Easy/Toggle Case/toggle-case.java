class Solution {
    public String toggleCase(String s) {
        // code here
        char[] arr = s.toCharArray();
        char[] ans = new char[s.length()];
        int i=0;
        for(char ch: arr){
            if(Character.isLowerCase(ch)) {
                ans[i] = Character.toUpperCase(ch);
            } else {
                ans[i] = Character.toLowerCase(ch);
            }
            i++;
        }
        
        return new String(ans);
    }
}
