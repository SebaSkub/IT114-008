<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone3</td></tr>
<tr><td> <em>Student: </em> Sebastian Skubisz (ss365)</td></tr>
<tr><td> <em>Generated: </em> 4/20/2023 10:56:09 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone3/grade/ss365" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;&nbsp;<a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Connection Screens </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the screens with the following data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/233518423-3269f83a-4ff6-4240-91c5-601d02bbce36.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>This screenshot displays the UI with Username, Host, and Port <br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the code for each step of the process</td></tr>
<tr><td> <em>Response:</em> <p>To establish a network connection, you need to specify three things: a username,<br>a host, and a port number.<div><div><ul><li>The username is the name of the user<br>account on the remote system you want to connect to. It is used<br>for authentication purposes and to grant you access to the remote system.</li></ul></div><div><ul><li>The host<br>is the address of the remote system you want to connect to.</li><li>The port<br>number is a number that identifies a specific application or service running on<br>the remote system. When you connect to a remote system, you need to<br>specify the port number associated with the service you want to access.&nbsp;<br></li></ul></div></div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Chatroom view </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/233520252-62c20464-a5b3-4d37-bcad-5b3e8b5cc45e.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show&#39;s list of users, chat message area, and send button<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/233520495-c9f8c4cd-ca54-4eb7-8641-4267580f5190.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>code snippet for so send button is activated with ENTER KEY<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Chat Activities </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show screenshots of the result of the following commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/233520837-6fe96004-a759-47b9-823e-c3e3f84b8f0e.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Flipping a Coin with /flip<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/233521001-ad914778-b210-4925-90f1-d0cb9f464642.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Rolling Dice demonstration with both formats /roll X-100 and /roll #d#<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the code snippets for each command</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/233521357-615385a0-f03a-4e8b-ae69-9035cd766214.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show the server-side code for /flip generation<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/233521468-d8f60a68-fac8-4cb8-85fa-df951e2e9479.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show the server-side code for the /roll generation (include /roll # and /roll<br>#d#)<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/233521643-c5cdb949-412c-4abe-a32d-654790e27826.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>text format logic just wrapped with HTML UCID and DATE are show with<br>/flip<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code flow of each command</td></tr>
<tr><td> <em>Response:</em> <div><ul><li>The logic behind the ROLL command is to generate a random number between<br>1 and a given number (or 100 by default) and send it back<br>to the client make sure it matches "/roll".</li><li>The server receives the ROLL command<br>from the client and extracts the maximum number (if provided) to generate the<br>random number.</li><li>The server generates a random number using a built-in random number generator<br>in the programming language used.</li></ul></div><div><ul><li>The server formats the output message and sends it<br>back to the client, which displays it to the user.</li></ul></div><div><br></div><div><div><ul><li>The logic behind the<br>FLIP command is to simulate a coin flip and send the result (heads<br>or tails) back to the client and make sure it matches "/flip".</li><li>The server<br>receives the FLIP command from the client and generates a random boolean value<br>(true or false) to represent the coin flip.</li><li>The server formats the output message<br>based on the result and sends it back to the client, which displays<br>it to the user.&nbsp;</li></ul></div></div><div><b>FLOW</b></div><div><div><ul><li>The client sends a message to the server, which processes<br>the message and sends a response back to the client.</li><li>The client receives the<br>response from the server and displays it to the user.</li><li>This process can repeat<br>multiple times as the user and other clients send messages to the server<br>and receive responses from it.</li></ul></div></div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Custom Text </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Screenshots of examples</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/233522605-d605f0dc-2525-417c-9cba-7f3858d0773a.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Add a screenshot showing bold working (correctly showing the text bold) Best to<br>show it bold as part of a larger message INPUT STRING USED <strong>BOLD</strong><br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/233522715-27a8ae00-4a53-4fd2-ac98-bc6d40f5749a.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Add a screenshot showing italic working (correctly showing the text italic) Best to<br>show it italic as part of a larger message INPUT STRING USED <del>BOLD</del><br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/233522904-5be788ae-288f-4544-9f05-20056935ebaf.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Add a screenshot showing color working (correctly showing the text colored) Best to<br>show it colored as part of a larger message  INPUT STRING USED<br><strong>#r#BOLD#r#</strong><br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/233523017-3a559b23-5f12-4837-be58-ffd3a14199a9.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Add a screenshot showing underline working (correctly showing the text underlined) Best to<br>show it underlined as part of a larger message  INPUT STRING USED<br><strong>BOLD</strong><br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/233523263-bb23285f-70c6-4b39-b230-8fad9cb5be8e.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Add a screenshot showing combinations of effects together working (bold, italic, underline and<br>color)  INPUT STRING USED <strong>#b#<strong>MULTIPLE STYLES</strong>#b#</strong><br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how you got the UI side to render the text accordingly</td></tr>
<tr><td> <em>Response:</em> <div><div>By setting the MIME type to "text/html", the JEditorPane component knows that the<br>text content should be treated as HTML code, which allows it to render<br>the content with styling and formatting.</div><div><br></div><div>Once the JEditorPane is created, it can be<br>added to a Swing container, such as a JPanel, and the text content<br>will be displayed using the HTML styling and formatting rules.&nbsp;</div></div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 5: </em> Whisper </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing a demo of whisper commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/233525136-342bd294-8fd1-48ad-8841-17e84966004f.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot should show at least 3 people and prove only the two parties<br>see the message in the same room (all parties should be present prior<br>to this test) Only John and Bob received private messages.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the server-side code snippets of how this feature works</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/233526920-5ccb4920-fb55-40e5-8337-e18429753c57.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Show how the message is processed to find the target of the whisper.<br>Show how the sender and the whisper target are the only ones to<br>get the message<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <div>In the sendMessage method, the code checks if the message starts with the<br>"@" symbol, which indicates that it is a private message. If it is<br>a private message, the code extracts the recipient's name from the message by<br>finding the first space character after the "@" symbol.</div><div><br></div><div>Then, the code loops through<br>all connected clients to find the one with the same name as the<br>recipient. When it finds a match, it sends the private message to that<br>client using the sendMessage method of the ServerThread object representing that client.</div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 6: </em> Mute/Unmute </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots demoing this feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/233527947-decb368e-6c51-4c63-85dd-3b22db6fab9c.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Capture any output from mute/unmute commands can&#39;t seem to get mute and unmute<br>commands to work together with the list.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshots of the code snippets that achieve this feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/233528402-6cccb554-3fc6-470a-8282-861c5151854f.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>COMMAND TRIGGER MUTE and UNMUTE <br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/233528543-1f547b16-a8b0-40a7-ad24-bfb3bc5fdfc8.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Picture of code for ProcessCommand /mute and /unmute<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123407738/233528649-c42e6178-06b6-4cc5-b32a-e1aa24a9f3f4.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>This section of the code is responsible for broadcasting the message to all<br>clients, except the ones who have been muted. It does this by iterating<br>over the clients list, which contains all of the ServerThread<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <ul><li>processCommands in the ServerThread class that takes a message string and a ServerThread<br>object as parameters.</li><li>The method checks if the message starts with a command trigger,<br>which is stored in the constant COMMAND_TRIGGER. If it does, it extracts the<br>command and executes it.</li><li>processCommand in the Server class that takes a message string<br>as a parameter.&nbsp;</li><li>It checks if the message starts with the "/mute" or "/unmute"<br>commands, and if so, extracts the username and adds or removes it from<br>the mutedClients list accordingly. It then broadcasts a message to all connected clients<br>indicating that the user has been muted or unmuted.</li><li>Then the sendMessage method has<br>a if statement to check is the client is Muted before broadcasting to<br>everyone.</li></ul><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 7: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Pull request from milestone3 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/SebaSkub/IT114-008/pull/17">https://github.com/SebaSkub/IT114-008/pull/17</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone3/grade/ss365" target="_blank">Grading</a></td></tr></table>