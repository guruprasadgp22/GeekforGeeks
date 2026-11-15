class Solution {
    public long countEvenSum(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int odd = 0;
        int even = 0;
        long res = 0;
        for(int i=0;i<n;i++) {
            sum += arr[i];
            if(sum  % 2 == 0) {
                even++;
                res += even;
            } else {
                res += odd;
                odd++;
            }
        }
        return res;
    }
}