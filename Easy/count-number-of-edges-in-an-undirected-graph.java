/*
Problem: Count Number Of Edges In An Undirected Graph
Difficulty: Easy
Tags: N/A
URL: https://www.geeksforgeeks.org/problems/count-number-of-edges-in-an-undirected-graph/1
*/

class Solution {
    public int countEdges(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int total = 0;
        for(ArrayList<Integer> ls: adj) {
            total += ls.size();
        }
        
        return total/2;
    }
}