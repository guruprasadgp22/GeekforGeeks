class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        
        if(n==1) {
            for(int i=0;i<=9;i++) {
                result.add(i);
            }
            
            return result;
        }
        
        BFS(1, 0, n, result);
        
        return result;
    }
    
    private static void BFS(int start, int curr, int n, ArrayList<Integer> result) {
        if(n == 0) {
            result.add(curr);
            return;
        }
        
        for(int i=start;i<=9;i++) {
            int num = curr * 10 + i;
            BFS(i+1, num, n-1, result);
        }
    }
}
