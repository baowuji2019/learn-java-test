package com.mashibing.tank;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;

public class TankFrame extends Frame {
    int x = 200,y = 200;
    Dir dir = Dir.DOWN;
    private static final int SPEED = 10;
    public TankFrame(){
        setSize(800,600);
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
        System.out.println("paint");
        g.fillRect(x,y,50,50);
       // x +=10;
        // y +=10;
        
        
        switch(dir) {
        case LEFT:
        	x -= SPEED;
        	break;
        case UP:
        	y -= SPEED;
        	break;
        case RIGHT:
        	x += SPEED;
        	break;
        case DOWN:
        	y += SPEED;
        	break;
        	
         
        }



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
			if (bL) dir = Dir.LEFT;
			if (bU) dir = Dir.UP;
			if (bR) dir = Dir.RIGHT;
			if (bD) dir = Dir.DOWN;
			
		}




}
}