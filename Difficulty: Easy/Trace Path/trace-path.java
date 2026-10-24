class Solution {
    public boolean isPossible(int n, int m, String s) {
        int x = 0;
        int y = 0;
        int minX = 0;
        int maxX = 0;
        int minY = 0;
        int maxY = 0;
        
        for(char ch: s.toCharArray()) {
            if(ch == 'L') {
                y--;
            } else if(ch == 'R') {
                y++;
            } else if(ch == 'U') {
                x++;
            } else {
                x--;
            }
            
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }
        
        int r = maxX - minX + 1;
        int c = maxY - minY + 1;
        
        return r<= n && c <= m;

    }
}