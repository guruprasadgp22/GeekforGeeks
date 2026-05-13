class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        // Code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele: arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        
        list.sort((a, b) ->{
            if(a.getValue().equals(b.getValue())) {
                return b.getKey() - a.getKey();
            }
            
            return b.getValue() - a.getValue();
        });
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<k;i++) {
            ans.add(list.get(i).getKey());
        }
        
        return ans;
    }
}
