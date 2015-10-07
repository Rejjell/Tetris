package com.example.rummezheni.tetris;

import java.util.Calendar;
import java.util.Random;
import java.util.Timer;



public class Model {

	class Position{
		int I,J;
		public Position(int i,int j){
			I=i;J=j;
		}
		public Position(){
			
		}
	}
	
	private int[][] field;
	private Position[] position;
	private boolean onFloor;
	
	private int score;

	public int color;
	
	private Calendar calendar;
    private  Random random;

    public Position[] getFigurePosition(){
    	return position;
    	}
    
    public boolean isOnFloor(){
    	return onFloor;
    }
    
    int generateRandom(int n) {
    	random.setSeed(calendar.getTimeInMillis());
        return Math.abs(random.nextInt()) % n;
    }
	
		
		public int[][] getField(){
			return field;
		}

		public int getScore(){
			return score;
		}
		
		public void addScore(int s){
			score+=s;
		}
		
	
	public Model() {
		field = new int[10][20];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				field[i][j]=0;
			}
		}
		score=0;
		createFigure();
	}
    
	public void createFigure() {
		onFloor=false;
		calendar = Calendar.getInstance();
		random = new Random(calendar.getTimeInMillis());
		position= new Position[4];
		
		color=generateRandom(4)+1;
		
		int r=generateRandom(7);
		if (r==0){
		position[0]=new Position(4,-3);
		position[1]=new Position(4,-2);
		position[2]=new Position(4,-1);
		position[3]=new Position(4,0);
		}
		if (r==1){
		position[0]=new Position(4,-1);
		position[1]=new Position(5,-1);
		position[2]=new Position(4,0);
		position[3]=new Position(5,0);
		}
		if (r==2){
		position[0]=new Position(4,0);
		position[1]=new Position(5,0);
		position[2]=new Position(5,-1);
		position[3]=new Position(6,-1);
		}
		if (r==3){
		position[0]=new Position(3,-1);
		position[1]=new Position(3,0);
		position[2]=new Position(4,0);
		position[3]=new Position(5,0);
		}
		if (r==4){
		position[0]=new Position(3,0);
		position[1]=new Position(4,0);
		position[2]=new Position(5,0);
		position[3]=new Position(4,1);
		}
		if (r==5){
		position[0]=new Position(3,-1);
		position[1]=new Position(4,-1);
		position[2]=new Position(4,0);
		position[3]=new Position(5,0);
		}
		if (r==6){
		position[0]=new Position(3,0);
		position[1]=new Position(4,0);
		position[2]=new Position(5,0);
		position[3]=new Position(5,-1);
		}

	}
	
	public void moveFigureDown(){
		if (onFloor) return;
	
		int minI=10;
		int maxI=-1;
		int[] count = new int[10];
		for (int i = 0; i < position.length; i++) {
			if (position[i].I<minI) minI=position[i].I;
			if (position[i].I>maxI) maxI=position[i].I;
		}
		
		int j;
		for (int i = 0; i <10 ; i++) {
						
			j=0;
			while ((j!=20)&& (field[i][j]==0))  j++; 
			count[i]=j;	
		}

		for (int i = 0; i < position.length; i++) {	
			if (position[i].J+1==count[position[i].I])  onFloor=true;	
		}
		
		if (!onFloor)
		{
			for (int i = 0; i < position.length; i++) 
				position[i].J++;
		}
		
	}
	
	public void moveFigureLeft(){	
		if (onFloor) return;
		boolean left=true;
		for (int i = 0; i < position.length; i++) {
			if ((position[i].I<=0)||( (position[i].I>0)&&(position[i].J>=0)&&(field[position[i].I-1][position[i].J]!=0) ) ) left=false;	
		}
		
		if (left)
			for (int i = 0; i < position.length; i++) 
				position[i].I--;

	}
	
	public void moveFigureRight(){
		if (onFloor) return;
		boolean right=true;
		for (int i = 0; i < position.length; i++) {
			if ((position[i].I>=9)||( (position[i].I<9)&&(position[i].J>=0)&&(field[position[i].I+1][position[i].J]!=0) ) )  right=false;	
		}
		
		if (right)
			for (int i = 0; i < position.length; i++) 
				position[i].I++;

	}
	
	public void figureToField(){
		for (int i = 0; i < position.length; i++) {
			if ((position[i].J>=0)&&(position[i].J<20)&&(position[i].I>=0)&&(position[i].I<10)) field[position[i].I][position[i].J]=color;
		}
	}
		
	public void figureRotate(){
		int tmpI,tmpJ;
		Position[] newPos=new Position[4];	
		for (int i = 0; i < newPos.length; i++) {
			newPos[i]=new Position(0,0);
			tmpI=position[i].I-position[1].I;	
			tmpJ=position[i].J-position[1].J;
			
			newPos[i].I=tmpJ+position[1].I;	
			newPos[i].J=-tmpI+position[1].J;
		}
		
		boolean ok=true;
		for (int i = 0; i < newPos.length; i++) {
			if ((newPos[i].I<0)||(newPos[i].I>9))   ok=false;
			if ((newPos[i].J<0)||(newPos[i].J>19))  ok=false;
			if ((newPos[i].J>=0)&&(newPos[i].J<20)&&(newPos[i].I>=0)&&(newPos[i].I<10)&&(field[newPos[i].I][newPos[i].J]!=0)) ok=false;

		}
		
		if (ok)
		for (int i = 0; i < newPos.length; i++) {
			position[i].I= newPos[i].I;
			position[i].J=newPos[i].J;	
		}
	}
}
