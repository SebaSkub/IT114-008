<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone4</td></tr>
<tr><td> <em>Student: </em> Sebastian Skubisz (ss365)</td></tr>
<tr><td> <em>Generated: </em> 5/5/2023 8:36:24 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone4/grade/ss365" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;&nbsp;<a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Client can export chat history of their current session (client-side) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot of related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/236587343-b559015a-266b-4310-a90e-0b0ce3b8fe69.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>show&#39;s export button<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/236587804-e647f7d4-028e-4439-a3d6-ced51ea631d4.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Export file code<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/236587880-c0a881c4-f13e-4b92-8864-49380f2fcf2f.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>chatPanel methods<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot of exported data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/236587441-1cb0d139-776e-4d48-b3b9-2e094b55db82.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>demonstrates that export works<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/236587545-7e530519-41fe-429a-bd48-05cee3c5301e.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>examples with styling and formatting being captured<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <div>The getChatHistory() method retrieves the chat history from the chatPanel object and stores<br>it in a List of strings. It then exports the chat history to<br>a file or displays it in a new dialog box, depending on the<br>implementation.</div><div><br></div><div>The exportChatHistory() method retrieves the chat history from the chatPanel object and prompts<br>the user to choose a file location to save the chat history. It<br>then writes the chat history to the selected file using a BufferedWriter.&nbsp;</div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Client's mute list will persist across sessions (server-side) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707795-a9c94a71-7871-4572-bfae-ad636f8f8474.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a screenshot of how the mute list is stored</td></tr>
<tr><td><table><tr><td>Missing Image</td></tr>
<tr><td> <em>Caption:</em> (missing)</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add a screenshot of the code saving/loading mute list</td></tr>
<tr><td><table><tr><td>Missing Image</td></tr>
<tr><td> <em>Caption:</em> (missing)</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>(missing)</p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Client's will receive a message when they get muted/unmuted by another user </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a screenshot showing the related chat messages</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/236588218-c91f7c86-37d3-4b25-91fc-4223eb04ee17.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>show&#39;s that when a client is muted a private message is sent.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/236588187-fb9cc451-ba9b-4800-9acc-6d286aefe552.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>sendPrivMessage()<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/236588350-32550c78-d197-408c-bf42-d1fc685a8897.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>show&#39;s both Mute and Unmute messages<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add a screenshot of the related code snippets</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/236588015-732476eb-ae13-457a-a6dd-209929b87d76.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>command trigger for mute and unmute<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/236588100-fa5abca2-60f1-4ae4-bacf-ca0f9f69299b.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>sendPrivMessage this is the method that is triggered for /mute or /unmute<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>The sendPrivMessage() method sends a private message to a list of specified users.<br>It first checks the sender&#39;s client ID and adds a prefix to the<br>message indicating that it&#39;s a private message.&nbsp;<div>The processCommands() method processes the commands entered<br>by the clients. It first checks if the message starts with a command<br>trigger. If it does, it splits the message into two parts, the command<br>and the arguments. It then identifies the command and performs the appropriate action.<br>In this case, the two commands that are handled are &quot;MUTE&quot; and &quot;UNMUTE.&quot;&nbsp;</div><div>sendPrivMessage()<br>is sent when triggered with the desired format.<br></div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> User list should update per the status of each user </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707834-bf5a5b13-ec36-4597-9741-aa830c195be2.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot for Muted users by the client should appear grayed out</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/236588721-9e44e1b5-0d56-4f39-818a-51aaec367b09.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>didn&#39;t do it correctly but some attempt<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot for Last person to send a message gets highlighted</td></tr>
<tr><td><table><tr><td>Missing Image</td></tr>
<tr><td> <em>Caption:</em> (missing)</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>(missing)</p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone4/grade/ss365" target="_blank">Grading</a></td></tr></table>