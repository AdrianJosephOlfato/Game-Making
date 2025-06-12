 package com.mycompany.ponggame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{

	static final int GAME_WIDTH = 1500;  
	static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);  
	static final int BALL_DIAMETER = 20;
	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 100;
        static int ballPaddleCollisions=0;
        static int mode=0;
        
	 
        Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
     
        Paddle paddle1, paddle2;
	Ball ball;
	Score score;
	
	GamePanel(int gameMode){
                mode=gameMode;
		newPaddles();
                newBall();
		score = new Score(GAME_WIDTH,GAME_HEIGHT);
                
		this.setFocusable(true);
		this.addKeyListener(new AL());  
		this.setPreferredSize(SCREEN_SIZE);
		
		gameThread = new Thread(this);
		gameThread.start();
	}
        
        public void newBall() {
		random = new Random();
                if(ballPaddleCollisions==0) ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2), random.nextInt(GAME_HEIGHT-BALL_DIAMETER), BALL_DIAMETER, BALL_DIAMETER, 0,0,mode);
	        else ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2), random.nextInt(GAME_HEIGHT-BALL_DIAMETER), BALL_DIAMETER, BALL_DIAMETER, ball.xVelocity,ball.yVelocity,mode);
	}
        
	public void newPaddles() {
		paddle1 = new Paddle(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
		paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
	}
        
        @Override
	public void paint(Graphics g) { 
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);
	}
        
	public void draw(Graphics g) {
		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);
		score.draw(g);
                Toolkit.getDefaultToolkit().sync(); 

	}
        
	public void move() {
		paddle1.move();
		paddle2.move();
		ball.move();
	}
        
	public void checkCollision() {
		
		
		if(ball.y <=0) {  
			ball.setYVelocity(-ball.yVelocity);
		}
		if(ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
			ball.setYVelocity(-ball.yVelocity);
		}
                
		
		if(ball.intersects(paddle1)) {
                        ballPaddleCollisions++;
			ball.xVelocity = Math.abs(ball.xVelocity);
                        

			    if(ballPaddleCollisions%4==0 || mode<0) 
                            {
                                ball.xVelocity++; 
                                if(ball.yVelocity>0) ball.yVelocity++; 
                                else ball.yVelocity--;
                            }
                     
			ball.setXVelocity(ball.xVelocity);
			ball.setYVelocity(ball.yVelocity);
		}
		if(ball.intersects(paddle2)) {
                        ballPaddleCollisions++;
			ball.xVelocity = Math.abs(ball.xVelocity);
                        
			     if(ballPaddleCollisions%4==0  || mode<0) 
                             {
                                ball.xVelocity++; 
                                if(ball.yVelocity>0) ball.yVelocity++; 
                                else ball.yVelocity--;
                             }

			ball.setXVelocity(-ball.xVelocity);
			ball.setYVelocity(ball.yVelocity);
		}
                
		
		if(paddle1.y<=0)
			paddle1.y=0;
		if(paddle1.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
			paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
		if(paddle2.y<=0)
			paddle2.y=0;
		if(paddle2.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
			paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
                
		
		if(ball.x <=0) {
			score.player2++;
                        System.out.println("Player 2: "+score.player2+ " xVel | yVel: "+ ball.xVelocity+", "+ball.yVelocity);
			newPaddles();  
			newBall();
			
		}
		if(ball.x >= GAME_WIDTH-BALL_DIAMETER) {
			score.player1++;
                        System.out.println("Player 1: "+score.player1+ "  xVel | yVel: "+ ball.xVelocity+", "+ball.yVelocity);
			newPaddles();
			newBall();
			
		}
	}
        
        @Override
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks =60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				move();
				checkCollision();
				repaint();
				delta--;
			}
		}
	}
        
	public class AL extends KeyAdapter{          
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
	}
}