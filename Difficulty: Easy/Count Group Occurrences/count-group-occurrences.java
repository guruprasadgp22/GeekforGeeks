class Solution {
    int getCount(String s, int k) {
        int[] groups = new int[26];

        for (int i = 0; i < s.length(); i++) {
            // a new group starts at index 0 or when the character changes
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                groups[s.charAt(i) - 'a']++;
            }
        }

        int result = 0;
        for (int g : groups) {
            if (g == k) result++;
        }
        return result;
    }
}