/*
Problem: Geek And Her Destination  145724
Difficulty: Hard
Tags: N/A
URL: https://www.geeksforgeeks.org/problems/geek-and-her-destination--145724/1
*/

class Solution {
  static final long MOD = 1_000_000_007L;

  public int minTime(int a, int b, int d, int l, int r) {
    long g = a - b;
    long dLo = d - r, dHi = d - l;
    long cnt = dHi - dLo + 1;

    long sumD = ((dLo + dHi) * cnt / 2) % MOD;

    long sumK = (S(dHi - a, g) - S(dLo - a - 1, g)) % MOD;
    if (sumK < 0) {
      sumK += MOD;
    }
    long total = (sumD + 2L * b % MOD * sumK % MOD + cnt) % MOD;
    return (int)total;
  }

  private long S(long M, long g) {
    if (M <= 0) {
      return 0;
    }
    long q = M / g, rem = M % g;
    long full = (g * (q * (q + 1) / 2)) % MOD;
    long part = (rem % MOD) * ((q + 1) % MOD) % MOD;
    return (full + part) % MOD;
  }
}