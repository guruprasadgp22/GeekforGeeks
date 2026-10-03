class Solution {
    public ArrayList<ArrayList<Integer>> formCoils(int n) {
        int m = 8 * n * n;
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> ans1 = new ArrayList<>();
        ArrayList<Integer> ans2 = new ArrayList<>();
        
        int steps = 2;
        int flag = 1;
        int curr = 8 * n * n + 2 * n;
        ans2.add(curr);
        int index = 1;
        while(index < m){
            for(int i=0;i<steps&&index < m;i++) {
                curr = curr - (4*n*flag);
                ans2.add(curr);
                index++;
            }
            
            for(int i=0;i<steps && index < m;i++){
                curr = curr + flag;
                ans2.add(curr);
                index++;
            }
            
            flag *= -1;
            steps +=2;
        }
        
        for(int i=0;i<m;i++) {
            int ans = 16*n*n+1-ans2.get(i);
            ans1.add(ans);
        }
        
        Collections.reverse(ans1);
        Collections.reverse(ans2);
        
        result.add(ans1);
        result.add(ans2);
        
        return result;
    }
}