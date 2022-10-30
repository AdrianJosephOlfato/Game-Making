package com.mycompany.ponggame;

import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame{ // implements ActionListener{

//        JButton resetButton;
	
	GameFrame(int mode){
            
                if(mode>=0) this.setTitle("Ping Pong Game");
                else this.setTitle("Ping Pong Game - TRAINER MODE");
		this.setResizable(false);
		this.setBackground(Color.darkGray);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
////                panel .add(jButton1);
//                resetButton=new JButton();
//                resetButton.setText("close GAME");
//                resetButton.setSize(200,30);
//                resetButton.setLocation(0,560);
//                resetButton.addActionListener(this);
		this.add(new GamePanel(mode));
                
//                this.add(resetButton);
//                this.setSize(1015,635);
//                this.setLayout(null);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null); //locates game at centre
                
	}
}
