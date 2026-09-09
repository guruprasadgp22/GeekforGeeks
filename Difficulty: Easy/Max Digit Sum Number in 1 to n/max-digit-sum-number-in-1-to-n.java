class Solution {
    public static int sumOfDigits(long x) {
            int total = 0;
            while (x > 0) {
                total += (int) (x % 10);
                x /= 10;
            }
            return total;
        }

        public static long findMax(long n) {
            long ans = n;
            long maxSum = sumOfDigits(n);

            long b = 1;
            long temp = n;
            while (temp > 0) {
                long cur = (temp - 1) * b + (b - 1);
                if (cur > 0) {
                    long curSum = sumOfDigits(cur);
                    if (curSum > maxSum || (curSum == maxSum && cur > ans)) {
                        maxSum = curSum;
                        ans = cur;
                    }
                }
                temp /= 10;
                b *= 10;
            }

            return ans;
        }
}
