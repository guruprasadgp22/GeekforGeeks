/*
Problem: Range Vowel Count Queries Static
Difficulty: Medium
Tags: N/A
URL: https://www.geeksforgeeks.org/problems/range-vowel-count-queries-static/1
*/

class Solution {
    public ArrayList<Integer> countVowels(String s, int[][] queries) {
        int n = s.length();
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            boolean isVowel = ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
            prefix[i + 1] = prefix[i] + (isVowel ? 1 : 0);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            res.add(prefix[r + 1] - prefix[l]);
        }
        return res;
    }
}