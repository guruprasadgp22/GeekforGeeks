class Solution {
    public void solveSudoku(int[][] mat) {
        // code here
        int row = 0;
        int col = 0;
        
        boolean ans = suduko(mat, row, col);
    }
    
    public boolean suduko(int[][] board, int row, int col) {
        if(row == 9) {
            return true;
        }
        
        int nextRow = row;
        int nextCol = col + 1;
        if(nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }
        
        if(board[row][col] != 0) {
            return suduko(board, nextRow, nextCol);
        }
        
        for(int digit = 1; digit <= 9; digit++) {
            if(isSafe(board, row, col, digit)) {
                board[row][col] = digit;
                if(suduko(board, nextRow, nextCol)) {
                    return true;
                }
                
                board[row][col] = 0;
            }
        }
        
        return false;
    }
    
    private boolean isSafe(int[][] board, int row, int col, int n) {
        for(int i=0;i<9;i++) {
            if(board[row][i] == n) {
                return false;
            }
        }
        
        for(int i=0;i<9;i++) {
            if(board[i][col] == n) {
                return false;
            }
        }
        
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        
        for(int i=startRow; i <= startRow+2; i++) {
            for(int j=startCol; j<= startCol + 2; j++) {
                if(board[i][j] == n) {
                    return false;
                }
            }
        }
        
        return true;
    }
}