class Solution {
    public ArrayList<Integer> update(int n, int[] updates) {
        int[] diff = new int[n];
        for(int ele: updates) {
            diff[ele-1]++;
        }
        int curr = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(int ele: diff) {
            curr += ele;
            result.add(curr);
        }
        return result;
    }
}