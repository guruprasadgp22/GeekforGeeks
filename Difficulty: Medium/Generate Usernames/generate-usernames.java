class Solution {
    public ArrayList<String> generateUsernames(String[] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> used = new HashSet<>();
        HashSet<String> reserved = new HashSet<>(Arrays.asList(arr));
        ArrayList<String> result = new ArrayList<>();
        for(int i=0;i<arr.length;i++) {
            String s = arr[i];
            if(!used.contains(s)) {
                result.add(s);    
                used.add(s);
            } else {
                int k = map.getOrDefault(s, 1);
                while(reserved.contains(s + k) || used.contains(s + k)) {
                    k++;
                }
                reserved.add(s + k);
                used.add(s + k);
                result.add(s + k);
            }
        }
        return result;
    }
}