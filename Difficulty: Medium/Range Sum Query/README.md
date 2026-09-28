<h2><a href="https://www.geeksforgeeks.org/problems/sum-of-query-ii5310/1">Range Sum Query</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 18.6667px;">Given an array <strong>arr[]</strong> of n integers and a 2D array <strong>queries[][]</strong> containing <strong>q</strong> queries, where each query is of the form [l, r], find the sum of all elements from index l to r for each query.</span></p>
<p><span style="font-size: 14pt;"><strong>Note:</strong> Array is 1-Indexed.</span></p>
<p><span style="font-size: 14pt;"><strong>Examples :<br></strong></span></p>
<pre><span style="font-size: 14pt;"><strong>Input:</strong> arr[] = [1, 2, 3, 4], q = 2, queries[][] = [[1, 4], [2, 3]]
<strong>Output:</strong> [10, 5]
<strong>Explanation:</strong> In the first query we need sum from 1 to 4 which is 1+2+3+4 = 10. In the second query we need sum from 2 to 3 which is 2 + 3 = 5.<br></span></pre>
<pre><span style="font-size: 14pt;"><strong>Input:</strong> arr[] = [26, 30, 48, 29, 8], q = 2, queries[][] = [[4, 4], [2, 3]]
<strong>Output:</strong> [29, 78]
<strong>Explanation:</strong> In the first query we need sum from 4 to 4 which is 29. In the second query we need sum from 2 to 3 which is 30 + 48 = 78.</span></pre>
</div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Amazon</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Mathematics</code>&nbsp;<code>Prefix Sum</code>&nbsp;