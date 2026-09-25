class Box {
    int height;
    int width;
    int length;
    
    Box(int height, int width, int length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }
}

class Solution {
    private void addBox(List<Box> boxes, int a, int b, int c) {
        if(b < c) {
            int t = b;
            b = c;
            c = t;
        }
        
        boxes.add(new Box(a, b, c));
    }
    
    int[] dp;
    public int maxHeight(int[] height, int[] width, int[] length) {
        int n = length.length;
        
        List<Box> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            addBox(list, height[i], width[i], length[i]);
            addBox(list, width[i], length[i], height[i]);
            addBox(list, length[i], height[i], width[i]);
        }
        
        int boxSize = list.size();
        
        dp = new int[boxSize];
        Arrays.fill(dp, -1);
        
        int ans = 0;
        
        for(int i=0;i<boxSize;i++) {
            ans = Math.max(ans, solve(i, list));
        }
        
        return ans;
    }
    
    private int solve(int index, List<Box> boxes) {
        if(dp[index] != -1) {
            return dp[index];
        }
        
        Box curr = boxes.get(index);
        
        int maxHeight = curr.height;
        
        for(int i=0;i<boxes.size();i++) {
            Box next = boxes.get(i);
            if(next.width < curr.width && next.length < curr.length) {
                int height = curr.height + solve(i , boxes);
                
                maxHeight = Math.max(maxHeight, height);
            }
        }
        
        return dp[index] = maxHeight;
    }
}