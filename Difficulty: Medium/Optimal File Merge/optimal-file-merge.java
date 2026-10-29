class Solution {
    public int minComputation(int[] files) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a- b);
        for(int ele: files) {
            queue.add(ele);
        }
        
        int totalCost = 0;
        while(queue.size() > 1) {
            int sum = queue.poll() + queue.poll();
            queue.add(sum);
            totalCost += sum;
        }
        return totalCost;
    }
}