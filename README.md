# Ping Pong Game

It's a game based on java language, using feature of javax.swing, java.awt & other packages.

It's a 2 player game, having 2 modes, which decides, how speed of ball changes as game progresses.

1st mode is the normal game mode, in which speed of the ball increaes gradually, on the basis of number of collisions b/w ball and the paddles. Also after reaching a particular speed of ball, say level X speed, every time when game restarts due to missed collision b/w ball & paddle, ball restarts moving with a speed closer to level X speed, instead of level 0 speed. This is there to ensure that game's difficulty increases as game progresses.

2nd mode is Trainer mode. In this mode, with every collision b/w ball and paddle speed of ball increases, & everytime collision is missed, ball restarts with level 0 speed. This is there to train the ordinary player to a super level player.

## Screenshots

### Mode Selection Page
<img src="Screenshots\ModeSelectorPage.png">

### Mode 1: Normal Game Mode
<img src="Screenshots\NormalGameMode.png">

### Mode 2: Trainer Game Mode
<img src="Screenshots\TrainerMode.png">