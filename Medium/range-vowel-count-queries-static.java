/*
Problem: Range Vowel Count Queries Static
Difficulty: Medium
Tags: N/A
URL: https://www.geeksforgeeks.org/problems/range-vowel-count-queries-static/1
*/

tree[i] = tree[2*i+1] + tree[2*i+2];
    }
    
    int query(int left, int right) {
        return query(0, 0, n-1, left, right);
    }
    
    private int query(int i, int start, int end, int left, int right) {
        if(left > end || right < start) {
            return 0;
        }
        
        if(left <= start && right >= end) {
            return tree[i];
        }
        
        int mid = start + (end - start)/2;
        
        return query(2*i+1, start, mid, left, right) + query(2*i+2, mid+1, end, left, right);
    }
    
    private boolean checkVowels(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
class Solution {
    public ArrayList<Integer> countVowels(String s, int[][] queries) {
        SegmentTree st = new SegmentTree(s);
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int x[]: queries) {