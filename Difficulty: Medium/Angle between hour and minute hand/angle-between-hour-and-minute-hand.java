class Solution {
    public double getAngle(String s) {
        // code here
        String[] arr = s.split(":");
        int hour = Integer.parseInt(arr[0]);
        int minute = Integer.parseInt(arr[1]);
        
        double hourAngle = (hour % 12) * 30 + minute * 0.5;
        double minuteAngle = minute * 6;
        double diff = Math.abs(hourAngle - minuteAngle);
        return Math.min(diff, 360 - diff);
    }
}