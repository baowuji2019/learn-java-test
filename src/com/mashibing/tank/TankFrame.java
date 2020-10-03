﻿package com.mashibing.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;

public class TankFrame extends Frame {
    //int x = 200,y = 200;
    //Dir dir = Dir.DOWN;
    //private static final int SPEED = 10;
    
    Tank myTank = new Tank(200,200,Dir.DOWN);
    Bullet b = new Bullet(300,300,Dir.DOWN);
    
    static final int GAME_WIDTH = 800 ,GAME_HEIGHT = 600;
    
    public TankFrame(){
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            
            }
        });

        addKeyListener(new MyKeyListener());

    }

    @Override
    public void paint(Graphics g){
        //System.out.println("paint");
       // x +=10;
        // y +=10;
        
        myTank.paint(g);
        b.paint(g);
       
    }
    
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
    	if (offScreenImage == null ) {
    		
    		offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
    		
    	}
    	Graphics goffScreen = offScreenImage.getGraphics();
    	Color c = goffScreen.getColor();
    	goffScreen.setColor(Color.white);
    	goffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
    	goffScreen.setColor(c);
    	paint(goffScreen);
    	g.drawImage(offScreenImage,0,0,null);
    	
    	
    	
    }

    class MyKeyListener extends KeyAdapter{
    	
    	boolean bL = false;
    	boolean bU = false;
    	boolean bR = false;
    	boolean bD = false;
    	
    	
    	
        @Override
        public void keyPressed(KeyEvent e){
            System.out.println("key pressed");
            int key = e.getKeyCode();
            switch(key) {
            	case KeyEvent.VK_LEFT:
            		bL = true;
            		break;
            	case KeyEvent.VK_UP:
            		bU = true;
            		break;
            	case KeyEvent.VK_RIGHT:
            		bR = true;
            		break;
            	case KeyEvent.VK_DOWN:
            		bD = true;
            		break;
            	default:
            		break;
            	            	            	            	         	            	
            	}           
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e){
            System.out.println("key released");
            int key = e.getKeyCode();
            switch(key) {
            	case KeyEvent.VK_LEFT:
            		bL = false;
            		break;
            	case KeyEvent.VK_UP:
            		bU = false;
            		break;
            	case KeyEvent.VK_RIGHT:
            		bR = false;
            		break;
            	case KeyEvent.VK_DOWN:
            		bD = false;
            		break;
            	default:
            		break;

        }
            setMainTankDir();



    }

		private void setMainTankDir() {
			// TODO Auto-generated method stub
					
			if(!bL && !bU && !bR && !bD ) myTank.setMoving(false);
			else {
				myTank.setMoving(true);
				if (bL) myTank.setDir(Dir.LEFT) ;
				if (bU) myTank.setDir(Dir.UP) ;
				if (bR) myTank.setDir(Dir.RIGHT) ;
				if (bD) myTank.setDir(Dir.DOWN) ; 				
			}
		}




}
}