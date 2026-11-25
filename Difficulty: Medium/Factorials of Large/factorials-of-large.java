class Solution {
    public ArrayList<Integer> factorial(int n) {
        int size = 1;
        int[] arr = new int[10000];
        arr[0] = 1;
        
        for(int i=2;i<=n;i++) {
            size = multiply(arr, size, i);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=size-1;i>=0;i--) {
            res.add(arr[i]);
        }
        
        return res;
    }
    
    private int multiply(int[] arr, int size, int multiplier) {
        int carry = 0;
        
        for(int i=0;i<size;i++) {
            int res = arr[i] * multiplier;
            res = res + carry;
            arr[i] = res % 10;
            carry = res / 10;
        }
        
        while(carry > 0) {
            arr[size++] = carry % 10;
            carry /= 10;
        }
        
        return size;
    }
}