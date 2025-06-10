package com.mycompany.ponggame;

import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame{ 
	
	GameFrame(int mode){
            
                if(mode>=0) this.setTitle("Ping Pong Game");
                else this.setTitle("Ping Pong Game - TRAINER MODE");
		this.setResizable(false);
		this.setBackground(Color.white);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                

		this.add(new GamePanel(mode));
                
         
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
                
	}
}
