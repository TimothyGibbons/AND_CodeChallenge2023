# AND Digital Coding Challenges

## All Challenges are saved as individual branches. Please see branch for challenge code.

- Challenge 1: "ControlC, Control V"
- Challenge 2: "Langton's Ant"


### 🏆 Challenge 2
The task this week is to create a simulation of Langton's Ant. Langton's Ant is a cellular automaton that moves around a two-dimensional grid of black and white cells. The ant can face one of four different directions - north, south, east or west. At each step of the simulation the ant will decide where to move - if the ant is currently on a black cell then it turns 90 degrees to the right and moves forward one cell . Similarly, if the ant is on a white cell then it turns 90 degrees to the left and moves forward one cell. Whenever the ant leaves a cell, it inverts the colour of that cell. You're free to choose the starting size and colour of your grid, as well as the starting direction and position of the ant.

#### Rewards:
- 5️⃣ Points are awarded for a working simulation of Langton's Ant with a simple user interface to display the grid and the ant's movement.
- 3️⃣ Further points are awarded for creating your simulation in a unique choice of language (or a unique frontend JavaScript framework).
- 2️⃣ Further points are awarded for expanding the grid by one cell in all directions if the ant attempts to move outside of the grid.

#### Submission:
When you have a solution, submit a link to your source code repo (#coding-challenges) using the /submit command here on Slack. Please include any code and data required in order to test your solution easily. Submission closes noon on the 1st March.
Good luck! (edited)

![langant_360.gif](images/langant_360.gif)


### 🏆 Challenge 3 - "Text In Transit" 🔤

@here The challenge is to build a fixed-width, right-to-left text scroller capable of taking a string parameter and screen width as inputs. Seems simple, right?

Rewards:
- 4️⃣  Points are awarded for a working text scroller demonstrated in either a console window or web app.
- 2️⃣  Further points are awarded for supporting sections of bold and underlined text (see examples)
- 2️⃣  Further points are awarded for supporting sections of coloured text (see examples)
- 1️⃣  Further point is awarded for supporting some kind of 'speed' input (e.g. characters per second)
- 1️⃣  Further point is awarded for supporting nested formatting (e.g. bold, underlined, coloured text (see example)).

Examples:
scroll(text: "Welcome on board this service to [B]London[/B]. Please have [U]all[/U] tickets and passes ready for inspection. This service is expected to depart [C:#00FF00]on time[/C]", screenWidth: 10, speed: 2)

scroll(text: "[C:#FF0000]All of this text is Red, but [C:#0000FF][B][U]THIS[/U][/B] text is Blue.[/C][/C]", screenWidth: 8, speed: 4)

Submission:
When you have a solution, submit a link to your source code repo using the /submit command here on Slack. Please include any code and data required in order to test your solution easily. Submission closes 23rd March, 17:00

[  "          ",  "         G",  "        Go",  "       Goo",  "      Good",  "     Good ",  "    Good l",  "   Good lu",  "  Good luc",  " Good luck",  "ood luck ",  "od luck  ",  "d luck   ",  "luck     ",  "uck      ",  "ck       ",  "k        ",  "         ",]