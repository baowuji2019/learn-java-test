package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Tank {
	private static final int SPEED = 2;
	public static int WIDTH =ResourceMgr.goodTankD.getWidth();
	public static int HEIGHT = ResourceMgr.goodTankD.getHeight();
	
	private Random random = new Random();
	
	private int x,y;
	private Dir dir = Dir.DOWN;
	private boolean moving = true;
	private TankFrame tf = null;
	private boolean living = true;
	private Group group = Group.BAD;
	
	
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Tank(int x, int y, Dir dir,Group group,TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		this.group = group;
	}
	public void fire() {
		// TODO Auto-generated method stub
		int bx = this.x + Tank.WIDTH/2 - Bullet.WIDTH+4;
		int by = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2+4;

		tf.bullets.add(new Bullet(bx,by,this.dir,this.group,tf));
		
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
        
        if (this.group == Group.BAD &&  random.nextInt(100) > 95 ) this.fire();
        
        
        if (this.group == Group.BAD &&  random.nextInt(100) > 95) randomDir();
        

		
	}
	
	
	private void randomDir() {
		// TODO Auto-generated method stub
		
		this.dir = Dir.values()[random.nextInt(4)] ;
		
	}
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
		if (! living ) tf.tanks.remove(this);
		
		switch(dir)	{
		
        case LEFT:
        	g.drawImage(this.group == Group.GOOd ? ResourceMgr.goodTankL :ResourceMgr.badTankL , x, y, null);
        	break;
        case UP:
        	g.drawImage(this.group == Group.GOOd ? ResourceMgr.goodTankU :ResourceMgr.badTankU , x, y, null);
        	break;
        case RIGHT:
        	g.drawImage(this.group == Group.GOOd ? ResourceMgr.goodTankR :ResourceMgr.badTankR , x, y, null);
        	break;
        case DOWN:
        	g.drawImage(this.group == Group.GOOd ? ResourceMgr.goodTankD :ResourceMgr.badTankD , x, y, null);
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
