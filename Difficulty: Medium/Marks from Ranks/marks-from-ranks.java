class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        // code here
        int n = l.length;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<n;i++) {
            int left = l[i];
            int right = r[i];
            
            for(int mark = left; mark <= right; mark++) {
                list.add(mark);
            }
        }
        
        ArrayList<Integer>  result = new ArrayList<>();
        for(int a: rank) {
            result.add(list.get(a-1));
        }
        
        return result;
    }
}