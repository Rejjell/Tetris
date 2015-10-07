package com.example.rummezheni.tetris;
/*
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import tetris.Model.Position;*/

public class Controller {
/*
	Model model;
	View view;
	boolean isGameOver=false;
	Timer timer;
	TimerTask task;
	boolean isSpeed=false;
	
	public Controller(Model m,View v){
		model= m;
		view=v;
		
        v.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                keyPress(evt);
            }
            public void keyReleased(KeyEvent evt)
            {
            	keyRelease(evt);
            }
        }); 
        
		createTimer(300);
	}
	
	public void tick() {
		  model.moveFigureDown();
		  if (model.isOnFloor()) {
			  model.figureToField();
			  clearLines();
			  testGameOver();
			  if (!isGameOver) model.createFigure();	
		  }
	}
	
    public void clearLines(){
    	int[][] field=model.getField();
		boolean fullLine;
		int[] indexes=new int[4];
		for (int i = 0; i < indexes.length; i++) {
			indexes[i]=100;
		}
		Position[] position=model.getFigurePosition();
		for (int i = 0; i < position.length; i++) {
			if (position[i].J>=0) indexes[i]=position[i].J;
		}
		
		int tmp;
	
		for (int i = 0; i < indexes.length; i++) {
			for (int j = i+1; j < indexes.length; j++) {
				if (indexes[i]==indexes[j]) indexes[i]=100;
			}
			}
		
		for (int i = 0; i < indexes.length; i++) {
			for (int j = 0; j < indexes.length; j++) {			
				if (indexes[i]<indexes[j]){
					tmp=indexes[i];
					indexes[i]=indexes[j];
					indexes[j]=tmp;				
				}
			}
		}
		
		int sc=0;
		
		for (int i = 0; i < indexes.length; i++) {
			if (indexes[i]!=100){
				fullLine=true;
				for (int j = 0; j < 10; j++) {
					if (field[j][indexes[i]]==0) fullLine=false;
				}

				if (fullLine){
				sc++;
				for (int J=indexes[i];J>=0;J--){
					for (int I=0;I<10;I++){
						if (J>0) field[I][J]=field[I][J-1];
						else field[I][J]=0;
					}
				}
				}
			}
		}
		model.addScore(sc*sc*10);
	}
    
    public void testGameOver(){
		for (int i = 0; i < 10; i++) {
			if (model.getField()[i][0]!=0) {timer.cancel();isGameOver=true;}
		}
    }
    
	   public void keyRelease(KeyEvent evt){
	    	switch (evt.getKeyCode()) {
	        case KeyEvent.VK_DOWN:
	        	timer.cancel();
	      		createTimer(300);
		   		  isSpeed=false;
	            break;
	    	}
	    }
	    
	    public void keyPress(KeyEvent evt) {
	     switch (evt.getKeyCode()) {
	            case KeyEvent.VK_UP:
	            	model.figureRotate();
	            	view.repaint();
	       		    break;
	            case KeyEvent.VK_LEFT:
	            	model.moveFigureLeft();
	            	view.repaint();
					break;
	            case KeyEvent.VK_RIGHT:
	            	model.moveFigureRight();
	            	view.repaint();
	                break;
	            case KeyEvent.VK_DOWN:
	            if (!isSpeed){
	            	 isSpeed=true;
		             timer.cancel();
		             createTimer(50);
	            }
	            	break;             
	        }
	    }

	    public void createTimer(long delay){
			 timer = new Timer(true);
			  task = new TimerTask() {
				  public void run()
			      {		
					  tick();
					  view.scoreLabel.setText("Score: "+model.getScore());
					  view.repaint();
					  
			      }
			  };
			  timer.scheduleAtFixedRate ( task, delay,delay);
	    }*/
}
