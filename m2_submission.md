<table><tr><td> <em>Assignment: </em> IT114 M2 Java-HW</td></tr>
<tr><td> <em>Student: </em> Sebastian Skubisz (ss365)</td></tr>
<tr><td> <em>Generated: </em> 2/4/2023 6:07:07 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-m2-java-hw/grade/ss365" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p><br></p><p><strong>Template Files</strong>&nbsp;You can find all 3 template files in this gist:&nbsp;<a href="https://gist.github.com/MattToegel/fdd2b37fa79a06ace9dd259ac82728b6">https://gist.github.com/MattToegel/fdd2b37fa79a06ace9dd259ac82728b6</a>&nbsp;<br></p><p>Setup steps:</p><ol><li><code>git checkout main</code></li><li><code>git pull origin main</code></li><li><code>git checkout -b M2-Java-HW</code></li></ol><p>You'll have 3 problems to save for this assignment.</p><p>Each problem you're given a template&nbsp;<strong>Do not edit anything in the template except where the comments tell you to</strong>.</p><p>The templates are done in such a way to make it easier to capture the output in a screenshot.</p><p>You'll copy each template into their own separate .java files, immediately git add, git commit these files (you can do it together) so we can capture the difference/changes between the templates and your additions. This part is required for full credit.</p><p>HW steps:</p><ol><li>Open VS Code at the root of your repository folder</li><li>In VS Code create a new folder/directory called M2</li><li>Create 3 new files in this new M2 folder (Problem1.java, Problem2.java, Problem3.java)</li><li>Paste each template into their respective files</li><li><code>git add .</code></li><li><code>git commit -m "adding template baselines</code></li><li>Do the related work (you may do steps 8 and 9 as often as needed or you can do it all at once at the end)</li><li><code>git add .</code></li><li><code>git commit -m "completed hw"</code></li><li>When you're done push the branch<ol><li><code>git push origin M2-Java-HW</code></li></ol></li><li>Create the Pull Request with <b>main</b>&nbsp;as base and&nbsp;<strong>M2-Java-HW</strong>&nbsp;as compare (don't merge/close it yet)</li><li>Create a new file in the M2 folder in VS Code called m2_submission.md</li><li>Fill out the below deliverable items, save the submission, and copy to markdown</li><li>Paste the markdown into the m2_submission.md</li><li>add/commit/push the md file<ol><li><code>git add m2_submission.md</code></li><li><code>git commit -m "adding submission file"</code></li><li><code>git push origin M2-Java-HW</code></li></ol></li><li>Merge the pull request from step 11</li><li>On your local machine sync the changes<ol><li><code>git checkout main</code></li><li><code>git pull origin main</code></li></ol></li><li>Submit the link to the m2_submission.md file from the main branch to Canvas</li></ol><p><br></p></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Problem 1 - Only output Odd values of the Array under "Odds output" </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> 2 Screenshots: Clearly screenshot the output of Problem 1 showing the data and show the code</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/216791467-70d5a1c6-7a4a-40d4-b51e-2b9f4ab7d7c5.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>This screenshot show&#39;s the code and output data with my ucid and today&#39;s<br>date.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/216792051-32bf4820-ddcc-48ec-b6a4-60160bce29bd.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Odds output...<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Describe how you solved the problem</td></tr>
<tr><td> <em>Response:</em> <p>In order to output only odd values I used the modulus operator which<br>returns the division remainder. We can use this remainder to determine if the<br>value is odd or even. I used a for loop which goes through<br>each value in the array and does &quot;%2&quot; to each and returns either<br>0 or 1. Then we use the does not equal to expression, which<br>is &quot;!=&quot; which will filter through all the numbers in the array. The<br>numbers loop and if the remainder isn&#39;t 0 then the number on the<br>array is ODD and will be printed. If the remainder is 0 it<br>will continue.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Problem 2 - Only output the sum/total of the array values (the number must end in 2 decimal places, if it ends in 1 it must have a 0 at the end) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> 2 Screenshots: Clearly screenshot the output of Problem 2 showing the data and show the code</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/216791816-480ca68d-0e7b-4d8a-87c8-fc83119daec6.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>This screenshot displays the output of problem2.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/216792051-32bf4820-ddcc-48ec-b6a4-60160bce29bd.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>This screenshot displays my code in VS code.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Describe how you solved the problem</td></tr>
<tr><td> <em>Response:</em> <p>For getting the sum I used a for loop in order to get<br>the total with the first number and then save the first total. Next<br>step it adds the next number in the array to the already saved<br>total and so on until the last statement executes and the total is<br>printed.&nbsp;<div><br></div><div>For the decimal deliverable for this HW, I just used the java formatting<br>instruction syntax &quot;%.2f&quot; which tells java to return your variable with 2 decimal<br>places.</div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Problem 3 - Output the given values as positive under the "Positive Output" message (the data otherwise shouldn't change) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> 2 Screenshots: Clearly screenshot the output of Problem 3 showing the data and show the code</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/216793011-cbc97caa-890f-4599-baeb-48b086d6d0f4.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>This screenshot has the included code<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/216793031-efbd240c-1096-42b7-9975-cc51a6190d6e.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>This screenshot Displays the output of the problem<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Describe how you solved the problem</td></tr>
<tr><td> <em>Response:</em> <p>To convert the negative values in the array to positive ones, I used<br>the Math.abs method in order to return the absolute (positive) value of the<br>given array.&nbsp;<div><br></div><div>Conversion of the Superclass object of the array to an Integer, Double,<br>or String object with downcasting by using (Integer), (Double), and (String) in every<br>instance. Determines if Int, Double, or String. If is a string then it<br>will parseInt converting the String into a value that we can actually evaluate.</div><div><div><br></div><div><br></div></div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc Items </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Pull Request URL for M2-Java-HW to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/SebaSkub/IT114-008/pull/7">https://github.com/SebaSkub/IT114-008/pull/7</a> </td></tr>
<tr><td> <em>Sub-Task 2: </em> Talk about what you learned, any issues you had, how you resolve them</td></tr>
<tr><td> <em>Response:</em> <p>For the Java Problems assignment, I learned how to properly use arrays, loops,<br>and formatting. The conversions will also be useful to know in the future<br>like for strings and converting from and float back to an int etc.<br>Very helpful for the understanding of Java and also getting a hang of<br>GitHub and realizing why I had so many pull requests on GitHub I<br>kept merging after everything I did.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-m2-java-hw/grade/ss365" target="_blank">Grading</a></td></tr></table>