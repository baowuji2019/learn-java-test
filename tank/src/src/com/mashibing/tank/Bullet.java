package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {
	private static final int SPEED = 5;
	public static int WIDTH =ResourceMgr.bulletD.getWidth();
	public static int HEIGHT = ResourceMgr.bulletD.getHeight();
	
	Rectangle rect = new Rectangle();
	
	private int x,y;
	private Dir dir;
	private boolean living = true;
	TankFrame tf = null;
	private Group group = Group.BAD;
	
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Bullet(int x, int y, Dir dir,Group group,TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		this.group = group;
		
		rect.x = this.x;
		rect.y = this.y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
	}
	
	public void paint(Graphics g) {
		
		if (!living) 
			tf.bullets.remove(this);
		
		switch(dir)	{
		
        case LEFT:
        	g.drawImage(ResourceMgr.bulletL, x, y, null);
        	break;
        case UP:
        	g.drawImage(ResourceMgr.bulletU, x, y, null);
        	break;
        case RIGHT:
        	g.drawImage(ResourceMgr.bulletR, x, y, null);
        	break;
        case DOWN:
        	g.drawImage(ResourceMgr.bulletD, x, y, null);
        	break;
        	
		
			
		}
		
		
/*		
		
		Color c = g.getColor();
		
		g.setColor(Color.RED);
		g.fillOval(x,y,WIDTH,HEIGHT);
		g.setColor(c);
*/		
		move();
		
		
		
	}
	
	private void move() {
		// TODO Auto-generated method stub
		
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
        
        //更新rect
        rect.x = this.x ;
        rect.y = this.y;
        
        if (x<0 || y < 0 || x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT) living = false;
		
	}

	public void collideWith(Tank tank) {
		
		if (this.group == tank.getGroup()) return;
		
		//用一个rect来记录子弹的位置，即可
		
		
		// TODO Auto-generated method stub
		//辅助类Rectangle,每次new一个新对象，会很耗内存
		//Rectangle rect1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
		//Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
		
		
		
		
		
		//相交即为相撞
		//if (rect1.intersects(rect2)) {
			
		if (rect.intersects(tank.rect)) {	
			
			tank.die();
			this.die();
			
			int ex = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH;
			int ey = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
			
			
			tf.explodes.add(new Explode(ex,ey,tf));
			
			
		}
		
		
		
		
	}

	private void die() {
		// TODO Auto-generated method stub
		this.living = false;
		
	}
	

}
