class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        // code here
        Stack<Integer> stack = new Stack<>();
        for(int ele: arr) {
            while(ele < 0 && !stack.isEmpty() && stack.peek() > 0) {
                int sum = ele + stack.peek();
                
                if(sum < 0) {
                    stack.pop();
                } else if(sum > 0) {
                    ele = 0;
                } else {
                    stack.pop();
                    ele = 0;
                }
            }
            
            while(ele > 0 && !stack.isEmpty() && stack.peek() < 0) {
                int sum = ele + stack.peek();
                
                if(sum > 0) {
                    stack.pop();
                } else if(sum < 0) {
                    ele = 0;
                } else {
                    stack.pop();
                    ele = 0;
                }
            }
            
            if(ele != 0) {
                stack.add(ele);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int ele: stack){
            result.add(ele);
        }
        
        return result;
    }
}