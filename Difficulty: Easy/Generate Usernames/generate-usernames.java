class Solution {
    public ArrayList<String> generateUsernames(String[] arr) {
        Set<String> reserved = new HashSet<>(Arrays.asList(arr));
        Set<String> used = new HashSet<>();
        Map<String, Integer> nextSuffix = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        for (String s : arr) {
            if (!used.contains(s)) {
                // first occurrence keeps its name
                used.add(s);
                result.add(s);
            } else {
                int k = nextSuffix.getOrDefault(s, 1);
                String candidate = s + k;
                while (reserved.contains(candidate) || used.contains(candidate)) {
                    k++;
                    candidate = s + k;
                }
                used.add(candidate);
                result.add(candidate);
                nextSuffix.put(s, k + 1);   // next time, start after this suffix
            }
        }
        return result;
    }
}