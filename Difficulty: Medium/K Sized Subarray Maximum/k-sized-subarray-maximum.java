class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<arr.length;i++) {
            while(!dq.isEmpty() && dq.getFirst() <= i - k) {
                dq.removeFirst();
            }
            
            while(!dq.isEmpty() && arr[i] >= arr[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
            if(i >= k-1) {
                res.add(arr[dq.getFirst()]);
            }
        }
        return res;
    }
}