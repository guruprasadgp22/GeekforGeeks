class Solution {
    static boolean isValid(int mat[][]) {
        // code here
        HashSet<String> set = new HashSet<>();
        
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                int ch = mat[i][j];
                
                if(ch == 0) {
                    continue;
                }
                
                String row = ch + " in row " + i;
                String col = ch + " in col " + j;
                String box = ch + " in box " + i/3 + " - " + j/3;
                
                if(set.contains(row) || set.contains(col) || set.contains(box)) {
                    return false;
                }
                
                set.add(row);
                set.add(col);
                set.add(box);
            }
        }
        
        return true;
    }
}