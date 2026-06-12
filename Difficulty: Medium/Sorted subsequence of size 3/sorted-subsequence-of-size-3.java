class Solution {
    public ArrayList<Integer> find3Numbers(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int prevFirst = Integer.MAX_VALUE;
        
        for(int ele: arr) {
            if(ele <= first ) {
                first = ele;
            } else if(ele <=  second) {
                second = ele;
                prevFirst = first;
            } else {
                ans.add(prevFirst);
                ans.add(second);
                ans.add(ele);
                return ans;
            }
        }
        
        return new ArrayList<>();
    }
}