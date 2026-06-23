class Solution {
    int maxPeopleDefeated(int p) {
        // code here
        int sum = 0;
        int i=0;
        while(sum <= p) {
            i++;
            sum += i * i;

        }
        
        return i-1;
    }
};