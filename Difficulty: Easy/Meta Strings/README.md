<h2><a href="https://www.geeksforgeeks.org/problems/meta-strings5713/1">Meta Strings</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 18px;">Given two strings <strong>s1</strong> and <strong>s2</strong> consisting of lowercase english alphabets, check whether these strings are <strong>meta </strong>strings or not.</span></p>
<p><span style="font-size: 18px;"><strong>Note:</strong> </span><span style="font-size: 18px;">Meta strings are the strings which can be made equal by exactly one swap in any of the strings. Equal string are not considered here as Meta strings.</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>s1 = "geeks", s2 = "keegs"
<strong>Output:</strong> true
<strong>Explanation</strong>: We can swap the 0th and 3rd character of s2 to make it equal to s1.</span>
</pre>
<pre><span style="font-size: 18px;"><strong>Input</strong>: s1 = "geeks", s2 = "geeks"
<strong>Output:</strong> false
<strong>Explanation</strong>: Equal strings are not considered Meta strings.</span>
</pre>
<pre><span style="font-size: 18px;"><strong>Input</strong>: s1 = "a", s2 = "b"
<strong>Output:</strong> false
<strong>Explanation</strong>: Since there is only character, we cannot do any swap.</span></pre>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 ≤ |s1|, |s2| ≤ 10<sup>5</sup></span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Google</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Strings</code>&nbsp;