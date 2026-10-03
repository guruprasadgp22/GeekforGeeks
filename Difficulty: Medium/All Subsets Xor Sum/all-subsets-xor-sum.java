class Solution {
    int subsetXORSum(int arr[]) {
       int or = 0;
       
       for(int n: arr){
           or |= n;
       }
       
       return or << arr.length-1;
        
    }
}