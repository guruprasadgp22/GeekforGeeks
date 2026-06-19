class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        
        for(int i=1;i<arr.length;i++) {
            result.add(result.get(result.size()-1) + arr[i] - arr[i/2]);
        }
        
        return result;
    }
}