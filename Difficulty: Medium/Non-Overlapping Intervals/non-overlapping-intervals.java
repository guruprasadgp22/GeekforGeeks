class Solution {
    public int minRemoval(int intervals[][]) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        int i = 0;
        int j = 1;
        int count = 0;
        
        while(j < n) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            int nextStart = intervals[j][0];
            int nextEnd = intervals[j][1];
            
            if(currEnd <= nextStart) {
                i = j;
                j++;
            } else if(currEnd <= nextEnd){
                j++;
                count++;
            } else if(currEnd > nextEnd) {
                i = j;
                count++;
                j++;
            }
        }
        
        return count;

    }
}
