class Solution {
    public int minInsAndDel(int[] a, int[] b) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < b.length; i++) {
            map.put(b[i], i);
        }

        ArrayList<Integer> arr = new ArrayList<>();

        for (int x : a) {
            if (map.containsKey(x)) {
                arr.add(map.get(x));
            }
        }

        int lcs = lis(arr);

        return (a.length - lcs) + (b.length - lcs);
    }

    private int lis(ArrayList<Integer> arr) {
        ArrayList<Integer> dp = new ArrayList<>();

        for (int x : arr) {
            int idx = Collections.binarySearch(dp, x);

            if (idx < 0) idx = -(idx + 1);

            if (idx == dp.size())
                dp.add(x);
            else
                dp.set(idx, x);
        }

        return dp.size();
    }
}