class Solution {
    public ArrayList<ArrayList<Integer>> socialNetwork(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = arr.length+1;
        
        for(int i=2;i<=n;i++) {
            int current = i;
            int jump = 0;
            int next = 0;
            int[] dist = new int[n+1];
            
            while(next != 1) {
                next = arr[current - 2];
                jump++;
                dist[next] = jump;
                current = next;
            }
            
            for(int j=1;j<i;j++) {
                if(dist[j] > 0) {
                    ArrayList<Integer> ans = new ArrayList<>();
                    ans.add(i);
                    ans.add(j);
                    ans.add(dist[j]);
                    result.add(ans);
                }
            }
        }
        
        return result;
    }
}