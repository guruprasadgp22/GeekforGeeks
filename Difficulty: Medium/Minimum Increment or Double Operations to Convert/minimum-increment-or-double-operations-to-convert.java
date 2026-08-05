class Solution {
    public int countMinOperations(int arr[]) {
        // code here
          int decrementCount = 0;
          int maxDivideCount = 0;
          
          for(int ele: arr) {
              int divideCount = 0;
              
              while(ele > 0) {
                  if(ele % 2 == 0) {
                      ele /= 2;
                      divideCount++;
                  } else {
                      ele--;
                      decrementCount++;
                  }
              }
              
              maxDivideCount = Math.max(maxDivideCount, divideCount);
          }
          
          return maxDivideCount + decrementCount;
    }
}