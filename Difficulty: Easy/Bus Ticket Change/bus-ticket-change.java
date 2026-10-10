class Solution {
    public boolean canServe(int[] arr) {
        int five = 0;
        int ten = 0;
        
        for(int ele: arr) {
            if(ele == 5) {
                five++;
            } else if(ele == 10) {
                ten++;
                
                if(five >= 1) {
                    five--;
                } else {
                    return false;
                }
            } else {
                if(ten >= 1 && five >= 1) {
                    five--;
                    ten--;
                } else if(five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        
        return true;

    }
}