package com.mycompany.ponggame;

import java.awt.*;

public class Score extends Rectangle{

	static int GAME_WIDTH;
	static int GAME_HEIGHT;
	int player1;
	int player2;
	
	Score(int GAME_WIDTH, int GAME_HEIGHT){
		Score.GAME_WIDTH = GAME_WIDTH;
		Score.GAME_HEIGHT = GAME_HEIGHT;
	}
        
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.setFont(new Font("Consolas",Font.PLAIN,60));
                
		// drawing the middle line using this line of code  // 1st & 2nd params are x & y coordinates of starting point of line, --
		g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);  // 4th param is height of line & 3rd param isn't clear
		
                //positioning scores of player 1 & 2 on the panel  //1st parameter is what to print, 2nd is x posn, 3rd is y posn
		g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), (GAME_WIDTH/2)-85, 50);
		g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), (GAME_WIDTH/2)+20, 50);
	}
}
