package com.mycompany.ponggame;

import java.awt.*;
import java.util.*;

public class Ball extends Rectangle{

	Random random;
	int xVelocity;
	int yVelocity;
	int initialSpeed = 6;
        
        Ball(int x, int y, int width, int height, int xVel, int yVel, int mode){ 
		super(x,y,width,height);  
		
                random = new Random();
                
		int randomXDirection = random.nextInt(2);
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
		x += xVelocity; 
                                 
		y += yVelocity;  
	}
        
	public void draw(Graphics g) {
		g.setColor(Color.pink);
		g.fillOval(x, y, height, width); 
	}
        
}
