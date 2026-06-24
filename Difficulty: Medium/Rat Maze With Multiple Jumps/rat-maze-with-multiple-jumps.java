class Solution {
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] ans = new int[n][m];
        boolean[][] dead = new boolean[n][m];

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (!dfs(0, 0, mat, ans, dead)) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(-1);
            res.add(temp);
            return res;
        }

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++)
                row.add(ans[i][j]);
            res.add(row);
        }

        return res;
    }

    boolean dfs(int i, int j, int[][] mat, int[][] ans, boolean[][] dead) {
        int n = mat.length, m = mat[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m || mat[i][j] == 0)
            return false;

        if (dead[i][j])
            return false;

        if (i == n - 1 && j == m - 1) {
            ans[i][j] = 1;
            return true;
        }

        ans[i][j] = 1;

        for (int k = 1; k <= mat[i][j]; k++) {
            if (dfs(i, j + k, mat, ans, dead))
                return true;

            if (dfs(i + k, j, mat, ans, dead))
                return true;
        }

        ans[i][j] = 0;
        dead[i][j] = true;   // memoize failure
        return false;
    }
}