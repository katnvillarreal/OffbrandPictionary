Welcome to Offbrand Pictionary! We're sorta like pictionary but a little off.

In order to install and run our program follow these simple steps:
1. Run xxamp and start mysql.
2. Open a command prompt and navigate to your student_space database.
3. Use source C:\PATHTOSQLFILE\offbrandPic.sql once in databse to implement the needed tables.
4. Open 4-9 command prompts depending on your desired number of players.
5. Using the included bat files use 1 command prompt to run the server bat file.
6. On all other prompts run client.bat with an IP address. If not connecting to an outside computer then type localhost

Example: `> client.bat localhost`
Example: `> client.bat 10.10.10.10`

7. Once the clients are running and connected one needs to either log in or create an account so that they can generate a lobby.
8. That user will then be presented with an options screen and they can choose how many players you want to play with and the catergory of words to draw.
9. After the lobby is generated then a lobby code will be presented to the user and that user can send the code for others to use to join the lobby. 
10. All other clients choose join lobby and use the code that the host player has given them.
11. Everyone needs to press "Ready Up" and once all players have readied up the game will start.
12. Enjoy the game!