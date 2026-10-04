class Solution {
    public static int kthLargest(int arr[], int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for(int ele: arr) {
            queue.add(ele);
        }
        
        while(k > 1) {
            k--;
            queue.poll();
        }
        
        return queue.poll();
    }
}