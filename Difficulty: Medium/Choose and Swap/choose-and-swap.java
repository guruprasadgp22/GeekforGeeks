class Solution {
    public String chooseSwap(String s) {
        List<Integer> first = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            first.add(-1);
        }

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (first.get(idx) == -1) {
                first.set(idx, i);
            }
        }

        char[] arr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            int curr = arr[i] - 'a';

            for (int ch = 0; ch < curr; ch++) {
                if (first.get(ch) > i) {
                    char c1 = arr[i];
                    char c2 = (char) (ch + 'a');

                    for (int j = 0; j < arr.length; j++) {
                        if (arr[j] == c1) {
                            arr[j] = c2;
                        } else if (arr[j] == c2) {
                            arr[j] = c1;
                        }
                    }

                    return new String(arr);
                }
            }
        }

        return s;
    }
}