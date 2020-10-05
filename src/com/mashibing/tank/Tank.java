package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	private static final int SPEED = 5;
	public static int WIDTH =ResourceMgr.TankD.getWidth();
	public static int HEIGHT = ResourceMgr.TankD.getHeight();
	private int x,y;
	private Dir dir = Dir.DOWN;
	private boolean moving = false;
	private TankFrame tf = null;
	private boolean living = true;
	
	public Tank(int x, int y, Dir dir,TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}
	public void fire() {
		// TODO Auto-generated method stub
		int bx = this.x + Tank.WIDTH/2 - Bullet.WIDTH+4;
		int by = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2+4;

		tf.bullets.add(new Bullet(bx,by,this.dir,tf));
		
	}
	
	
	public Dir getDir() {
		return dir;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public boolean isMoving() {
		return moving;
	}
	
	
	
	private void move() {
		// TODO Auto-generated method stub
		if (!moving) return;
		
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
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
		if (! living ) tf.tanks.remove(this);
		
		switch(dir)	{
		
        case LEFT:
        	g.drawImage(ResourceMgr.TankL, x, y, null);
        	break;
        case UP:
        	g.drawImage(ResourceMgr.TankU, x, y, null);
        	break;
        case RIGHT:
        	g.drawImage(ResourceMgr.TankR, x, y, null);
        	break;
        case DOWN:
        	g.drawImage(ResourceMgr.TankD, x, y, null);
        	break;
        	
		
			
		}
			
		
		//g.drawImage(ResourceMgr.TankL, x, y, null);
		
		//Color c = g.getColor();	
		//g.setColor(Color.YELLOW);		
        //g.fillRect(x,y,50,50);
        //g.setColor(c);

		
        
        move();
		
		
	}
	
	public void setDir(Dir dir) {
		this.dir = dir;
	}
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void die() {
		// TODO Auto-generated method stub
		this.living = false;
	}
	

}
