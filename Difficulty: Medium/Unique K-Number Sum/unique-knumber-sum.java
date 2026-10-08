class Solution {
    ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        result = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        solve(1, n, curr, k);
        return result;
    }
    
    private void solve(int start, int target, ArrayList<Integer> curr, int k) {
        if(target == 0 && curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        if(target < 0 || curr.size() > k) {
            return;
        }
        
        for(int i=start;i<=9;i++) {
            if(i > target) {
                break;
            }
            
            curr.add(i);
            solve(i+1, target-i, curr, k);
            curr.removeLast();
        }
    }
}