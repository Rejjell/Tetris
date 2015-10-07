package com.example.rummezheni.tetris;
/*
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tetris.Model.Position;*/

public class View /*extends JPanel*/ {
		/*
		final int blockSize=21;	
		boolean isSpeed=false;
		JLabel scoreLabel;
		Model model;
		Controller controller;
	
		public View(){
			
			scoreLabel = new JLabel("Image and Text");
			scoreLabel.setVerticalTextPosition(JLabel.BOTTOM);
			scoreLabel.setHorizontalTextPosition(JLabel.CENTER);
			this.add(scoreLabel);
	
			model=new Model();
			controller=new Controller(model,this);
	    }
		
		public void fillBlock(Graphics2D g,Color color ,int i, int j)	{
			g.setPaint(color);
			g.fillRect(i*blockSize+1 , j*blockSize+1, blockSize-1,blockSize-1);
		}
		
	  public void paintComponent(Graphics g2) {
		    super.paintComponent(g2);
		    Graphics2D g = (Graphics2D) g2;
		    
		    g.setPaint(Color.white);
			g.fillRect(0, 0, 10*blockSize, 20*blockSize);
			
			g.setPaint(Color.black);
			
			for (int i=0;i<11;i++)
				g.drawLine(i*blockSize, 0, i*blockSize,20*blockSize );
		
			for (int i=0;i<21;i++)
				g.drawLine(0,i*blockSize, 10*blockSize, i*blockSize);
			
			Color color=Color.white;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 20; j++) {
					
					switch ( model.getField()[i][j])
					{
					case 0: color=Color.white;	break;
					case 1:	color=Color.green; break;
					case 2:	color=Color.black; break;
					case 3:	color=Color.blue; break;
					case 4:	color=Color.red; break;
					}
					fillBlock(g,color, i, j);
				}
			}	
			
			
			for (int i = 0; i < 4; i++){
				switch ( model.color)
				{
				case 0: color=Color.white;	break;
				case 1:	color=Color.green; break;
				case 2:	color=Color.black; break;
				case 3:	color=Color.blue; break;
				case 4:	color=Color.red; break;
				}
				
				Position[] position=model.getFigurePosition();				
				fillBlock(g,color, position[i].I, position[i].J);
			}
			
	  }*/
	    
}
