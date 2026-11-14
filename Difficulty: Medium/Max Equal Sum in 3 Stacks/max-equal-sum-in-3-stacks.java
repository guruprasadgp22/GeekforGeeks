class Solution {
    public int maxEqualSum(ArrayList<Integer> s1, ArrayList<Integer> s2, ArrayList<Integer> s3) {
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for(int x: s1) {
            sum1 += x;
        }
        
        for(int x: s2) {
            sum2 += x;
        }
        
        for(int x: s3) {
            sum3 += x;
        }
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(!(sum1 == sum2 && sum2== sum3)) {
            if(sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= s1.get(i++);
            } else if(sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= s2.get(j++);
            } else {
                sum3 -= s3.get(k++);
            }
        }
        return sum1;
    }
}