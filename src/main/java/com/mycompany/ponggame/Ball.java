package com.mycompany.ponggame;

import java.awt.*;
import java.util.*;

public class Ball extends Rectangle{

	Random random;
	int xVelocity;
	int yVelocity;
	int initialSpeed = 4;
        
        Ball(int x, int y, int width, int height, int xVel, int yVel, int mode){ //x & y are coordinates of origin of ball once the ball is created
		super(x,y,width,height);  //super keyword is used to call the constructor of parent class, in our case Rectangle class & it takes 4 params
		
                random = new Random();
                
		int randomXDirection = random.nextInt(2);// gives back either 0 0r 1, as 2 is the upper bound in non inclusive way (for output)
		if(randomXDirection == 0)   randomXDirection--;
                if( Math.abs(xVel)>=5 && mode>=0) setXVelocity(randomXDirection*(xVel-(xVel%5)));
                else setXVelocity(randomXDirection*initialSpeed);
		
		int randomYDirection = random.nextInt(2);
		if(randomYDirection == 0)   randomYDirection--;
                if( Math.abs(yVel)>=5 && mode>=0) setYVelocity(randomYDirection*(yVel-(yVel%5)));
                else setYVelocity(randomYDirection*initialSpeed);
		
	}
	
	public void setXVelocity(int xVel) {
		xVelocity = xVel;
	}
        
	public void setYVelocity(int yVel) {
		yVelocity = yVel;
	}
        
	public void move() {
		x += xVelocity;  // this x is the variable of parent class i.e. Rectangle class, we only need to change this variable x
                                 // & Rectangle class will take of represnting the ball at that x coordinate on the panel
		y += yVelocity;  // this y variable too is from parent class , i.e. Rectangle class
	}
        
	public void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(x, y, height, width); //if this line is omitted, ball will exist, but will not be visible, & scores will keep changing
	}
        
}
