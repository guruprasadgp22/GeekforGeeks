class Solution {
    final int MOD = 1_000_000_007;
    public int countWays(int n, int m) {
        // code here
        Deque<Integer> queue = new LinkedList<>();
        
        for(int i=1;i<=n;i++) {
            if(i < m) {
                queue.addLast(1);
            } else if(i == m) {
                queue.addLast(2);
            } else {
                int ways = (queue.getLast() + queue.getFirst()) % MOD;
                queue.removeFirst();
                queue.addLast(ways);
            }
        }
        
        return queue.getLast();
    }
}