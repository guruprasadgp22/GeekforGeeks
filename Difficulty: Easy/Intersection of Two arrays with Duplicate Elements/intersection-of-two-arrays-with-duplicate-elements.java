class Solution {
    public ArrayList<Integer> intersect(int[] a, int[] b) {
        ArrayList<Integer> result  = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        for(int ele: a) {
            set.add(ele);
        }
        
        for(int ele: b) {
            if(set.contains(ele)) {
                result.add(ele);
                set.remove(ele);
            }
        }
        Collections.sort(result);
        return result;
    }
}