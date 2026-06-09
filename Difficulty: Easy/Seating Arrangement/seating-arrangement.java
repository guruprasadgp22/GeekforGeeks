class Solution {
    public boolean canSeatAllPeople(int k, int[] seats) {
        for(int i=0;i<seats.length-1;i++) {
            if(seats[i] == 1 && 1 == seats[i+1]) {
                return false;
            }
        }
        
        if(k == 0) {
            return true;
        }
        
        for(int i=0;i<seats.length;i++) {
            if(seats[i] == 0) {
                boolean left = (i==0) || (seats[i-1] == 0);
                boolean right = (i == seats.length-1) || (seats[i+1] == 0);
                
                if(left && right) {
                    seats[i] = 1;
                    k--;
                    
                    if(k == 0) {
                        return true;
                    }
                }
            }
        }
        
        return k <=0 ;
    }
}