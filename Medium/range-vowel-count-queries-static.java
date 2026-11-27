/*
Problem: Range Vowel Count Queries Static
Difficulty: Medium
Tags: N/A
URL: https://www.geeksforgeeks.org/problems/range-vowel-count-queries-static/1
*/

class Solution {
  public ArrayList<Integer> countVowels(String s, int[][] queries) {
    int n = s.length();
    int[] prefix = new int[n];
    prefix[0] = isVowel(s.charAt(0)) ? 1 : 0;
    for (int i = 1; i < n; i++) {
      char ch = s.charAt(i);
      boolean ans = isVowel(ch);
      prefix[i] = prefix[i - 1] + (ans ? 1 : 0);
    }

    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < queries.length; i++) {
      int src = queries[i][0];
      int dst = queries[i][1];
      int res = prefix[dst] - (src > 0 ? prefix[src - 1] : 0);
      result.add(res);
    }
    return result;
  }

  private boolean isVowel(char ch) {
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'u' || ch == 'o';
  }
}