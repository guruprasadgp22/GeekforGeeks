// User function Template for Java

class Sol {
    int[] count(String s) {
        // your code here
        int upper = 0;
        int lower = 0;
        int special = 0;
        int number = 0;
        
        for(char ch: s.toCharArray()) {
            if(ch >= 'a' && ch <= 'z') {
                lower++;
            } else if(ch >= 'A' && ch <= 'Z') {
                upper++;
            } else if(ch >= '0' && ch <= '9') {
                number++;
            } else {
                special++;
            }
        }
        
        int[] ans = new int[4];
        ans[0] = upper;
        ans[1] = lower;
        ans[2] = number;
        ans[3] = special;
        
        return ans;
    }
}