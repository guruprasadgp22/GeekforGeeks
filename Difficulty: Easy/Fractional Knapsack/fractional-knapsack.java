class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        int n = val.length;
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++) {
            arr[i][0] = val[i];
            arr[i][1] = wt[i];
        }
        
        Arrays.sort(arr, (a, b) -> {
            return Double.compare((double)b[0]/b[1], (double)a[0]/a[1]);
        });
        
        
            
        // bubbleSort(arr);
        double ans = 0;
        for(int i=0;i<n;i++) {
            int value = arr[i][0];
            int weight = arr[i][1];
            
            // System.out.println(value + " " + weight + " : " + ans);
            
            if(weight <= capacity) {
                ans += (value);
                capacity -= weight;
            } else {
                double a = (double)value/weight;
                ans += (a) * (capacity > 0? capacity: 0);
                capacity = 0;
            }
        }
        
        return ans;
    }
    
    private void bubbleSort(int[][] arr) {
        for(int i=0;i<arr.length-1;i++) {
            for(int j=0;j<arr.length-i-1;j++) {
                double a = (double) arr[j][0]/arr[j][1];
                double b = (double) arr[j+1][0]/arr[j+1][1];
                if(a < b) {
                    int temp[] = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        
        // for(int x[]: arr) {
        //     System.out.println(x[0] + " " + x[1] + " : " + (double) x[0]/x[1]);
        // }
    }
}