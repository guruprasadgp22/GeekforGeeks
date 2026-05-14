class Solution {

    public String encode(String arr[]) {
        // write your logic to encode the strings
        StringBuilder sb = new StringBuilder();
        
        for(String s: arr) {
            sb.append(s.length()).append("#").append(s);
        }
        
        return sb.toString();
    }

    public ArrayList<String> decode(String s) {
        // write your logic to decode the string
        ArrayList<String> list = new ArrayList<>();
        
        int i=0;
        while(i < s.length()) {
            int j = i;
            
            while(s.charAt(j) != '#'){
                j++;
            }
            
            int length = Integer.parseInt(s.substring(i, j));
            
            String word = s.substring(j+1, j+1+length);
            
            list.add(word);
            
            i = j+1+length;
        }
        
        return list;
    }
}