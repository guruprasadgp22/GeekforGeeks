class Solution {
    public ArrayList<String> permutation(String s) {
        // code here
        char[] arr = s.toCharArray();
        ArrayList<String> result = new ArrayList<>();
        int index = 0;
        
        permutation(arr, index, result);
        
        result.sort((a,b) -> {
           return a.compareTo(b); 
        });
        return result;
    }
    
    public void permutation(char[] arr, int index, ArrayList<String> result) {
        if(index == arr.length) {
            result.add(new String(arr));
            return;
        }
        
        for(int i=index;i<arr.length;i++) {
            swap(arr, index, i);
            permutation(arr, index+1, result);
            swap(arr, index, i);
        }
    }
    
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}