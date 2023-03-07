<table><tr><td> <em>Assignment: </em> It114 Milestone1</td></tr>
<tr><td> <em>Student: </em> Sebastian Skubisz (ss365)</td></tr>
<tr><td> <em>Generated: </em> 3/7/2023 12:48:33 AM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-milestone1/grade/ss365" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create a new branch called Milestone1</li><li>At the root of your repository create a folder called Project</li><ol><li>You will be updating this folder with new code as you do milestones</li><li>You won't be creating separate folders for milestones; milestones are just branches</li></ol><li>Create a milestone1.md file inside the Project folder</li><li>Git add/commit/push it to Github</li><li>Create a pull request from Milestone1 to main (don't complete/merge it yet)</li><li>Copy in the latest Socket sample code from the most recent Socket Part example of the lessons</li><ol><li>Recommended Part 5 (clients should be having names at this point and not ids)</li><li><a href="https://github.com/MattToegel/IT114/tree/Module5/Module5">https://github.com/MattToegel/IT114/tree/Module5/Module5</a>&nbsp;<br></li></ol><li>Git add/commit the baseline</li><li>Ensure the sample is working and fill in the below deliverables</li><li>Get the markdown content or the file and paste it into the milestone1.md file or replace the file with the downloaded version</li><li>Git add/commit/push all changes</li><li>Complete the pull request merge from step 5</li><li>Locally checkout main</li><li>git pull origin main</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Startup </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot showing your server being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/223322452-33045a3a-6a63-4d78-8feb-baa6cf14b72d.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Demonstrating that the server started and that it is properly listening to it&#39;s<br>port.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot showing your client being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/223322781-9b215baa-d45a-49c6-a9f4-a30b6499b399.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Demonstrating that the client successfully connected to the server and is waiting for<br>input. Also with a Name<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the connection process</td></tr>
<tr><td> <em>Response:</em> <p><font size="2">Server-side = contains main method and performs the work of listening to<br>the port, establishing connections, and reading and writing to the socket.</font><div><font size="2">Client-side =<br>server should already be running and listening to the port, waiting for a<br>client to request a connection. Waiting for client input most of the UI<br>lives here mostly for command purposes.</font></div><div><font size="2"><br></font></div><div><ol style="font-family: Arial, Helvetica, sans-serif;"><li><font size="2">Gets the<br>socket&#39;s input and output stream and opens readers and writers on them.</font></li><li><font size="2">Initiates<br>communication with the client by writing to the socket.</font></li><li><font size="2">Communicates with the client<br>by reading from and writing to the socket.</font></li></ol></div><div><br></div><div><br></div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Sending/Receiving </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/223325689-e64b876b-ab3e-4238-8b1d-091d2cfc35e2.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Demonstrates at least 2 clients connected to the server, and that the server<br>can handle client messages and broadcast them.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/223326193-0e9e917f-3c8b-44f9-a565-4000bc0317a8.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Demonstrates that Karol the client created and joined the room NJIT. The message<br>does not broadcast too the other client because they are in two different<br>rooms.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/223328892-574c9d86-5e01-4b0d-b260-7965f673adcd.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Clients are in 2 different rooms<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the messages are sent, broadcasted, and received</td></tr>
<tr><td> <em>Response:</em> <div>In the clients perspective, when the user runs the program and types something<br>in the command line and presses Enter, the Client-side sends the message to<br>the serverThread. Socket Client, command purposes</div><div><br></div><div>ServerThread actually send the message to both channels</div><div><br></div><div>Room<br>takes a sender and a message, and broadcasts the message to all clients<br>in the room.</div><div><br></div><div>Client receives message.</div><div><br></div><div>socket connection closed.</div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Disconnecting / Terminating </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/223329333-49022414-7c7a-4551-aff7-a32a6d9a6aee.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Client disconnected, also threw an exception<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/223329520-31081733-badb-45cc-8f76-ece3a7b84402.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Clearly show&#39;s a disconnected message with the specific client that disconnected.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/223329978-5a7940d9-01f7-4913-8008-473a9176d6a6.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Server terminated with the clients still running<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the various disconnects/terminations are handled</td></tr>
<tr><td> <em>Response:</em> <p><span style="color: rgb(34, 34, 34); font-family: &quot;Aspira Webfont&quot;, Helvetica, Arial, sans-serif; white-space: pre-wrap;">&lt;font<br>size=&quot;2&quot;&gt;A client gets disconnected from a socket perspective when the socket is closed.</font></span><div><br></div><div>&lt;font<br>size=&quot;2&quot;&gt;<span style="color: rgb(34, 34, 34); font-family: &quot;Aspira Webfont&quot;, Helvetica, Arial, sans-serif; white-space: pre-wrap;">The<br>client program doesn&#39;t crash when the server disconnects/terminates due to the socket still<br>being open, and the client can continue to communicate with the server until<br>all threads are disconnected.</span><font color="#222222" face="Aspira Webfont, Helvetica, Arial, sans-serif"><span style="white-space: pre-wrap;"><br></span></font></font></div><div>&lt;font color=&quot;#222222&quot;<br>face=&quot;Aspira Webfont, Helvetica, Arial, sans-serif&quot; size=&quot;2&quot;&gt;<span style="white-space: pre-wrap;"><br></span></font></div><div><font size="2"><span style="color: rgb(34, 34, 34);<br>font-family: &quot;Aspira Webfont&quot;, Helvetica, Arial, sans-serif; white-space: pre-wrap;">The server doesn&#39;t crash from the<br>client disconnecting due to the socket still being open. Hence why the Client<br>can still communicate with the Server even from the client&#39;s disconnecting.<br>&nbsp;</span><font color="#222222" face="Aspira<br>Webfont, Helvetica, Arial, sans-serif"><span style="white-space: pre-wrap;"><br></span></font></font><div><span style="color: rgb(34, 34, 34); font-family: &quot;Aspira Webfont&quot;,<br>Helvetica, Arial, sans-serif; font-size: 16px; white-space: pre-wrap;"><br></span></div></div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add the pull request for this branch</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/SebaSkub/IT114-008/pull/13">https://github.com/SebaSkub/IT114-008/pull/13</a> </td></tr>
<tr><td> <em>Sub-Task 2: </em> Talk about any issues or learnings during this assignment</td></tr>
<tr><td> <em>Response:</em> <p><span style="font-family: Arial, Helvetica, sans-serif; font-size: 12.8px;">A socket is a one-way of a<br>two-way communication link between two programs running on the network. Socket classes are<br>used to represent the connection between a client program and a server program.&nbsp;</span><div>&lt;font<br>face=&quot;Arial, Helvetica, sans-serif&quot;&gt;<span style="font-size: 12.8px;">Basically learned that client-side is more for input while<br>server-side is for processes.</span></font></div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-milestone1/grade/ss365" target="_blank">Grading</a></td></tr></table>
