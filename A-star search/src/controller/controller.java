package controller;



import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;

import model.Location;
import model.Zombie;
import view.Cursor;
import view.ZvsMushroom;


public class controller extends KeyAdapter{
	
	private JPanel panel;
	
	public controller(JPanel panel){
		this.panel = panel;
	}
	
	public void keyPressed(KeyEvent e){
		int[][] map = ((ZvsMushroom)panel).getMap();
		Cursor cursor = ((ZvsMushroom)panel).getCursors();
		Zombie c = ((ZvsMushroom)panel).getC();
		int k = e.getKeyCode();
		int direction = 0;
		int x = 0;
		int y = 0;
		switch(k){
			case KeyEvent.VK_UP:
				direction = -2;
				break;
				
			case KeyEvent.VK_DOWN:
				direction = 2;
				break;
				
			case KeyEvent.VK_LEFT:
				direction = -1;
				break;
				
			case KeyEvent.VK_RIGHT:
				direction = 1;
				break;
				
			case KeyEvent.VK_Q:  // create wall
			    Random rand = new Random();
			    int tt = rand.nextInt(5) + 2;
				x = cursor.getX();
				y = cursor.getY();
				map[y][x] = tt;
				 ((ZvsMushroom)panel).setMap(map);
				break;
			
			case KeyEvent.VK_W: // create ground
				x = cursor.getX();
				y = cursor.getY();
				map[y][x] = 1;
				 ((ZvsMushroom)panel).setMap(map);
				break;
				
			case KeyEvent.VK_SPACE: // choose & move
			    int x0 = c.getLo().getX();
                int y0 = c.getLo().getY();
                map[y0][x0] = 1;
				x = cursor.getX();
				y = cursor.getY();
				map[y][x] = 7;
				((ZvsMushroom)panel).setMap(map);
				Location lo = new Location(x,y);
				Thread move = new MoveThread(c,lo,map,cursor);
				move.start();
				break;	
		}
		cursor.move(direction);
	}
	
	class MoveThread extends Thread{
		private Zombie c;
		private Location lo;
		private int[][] map;
		
		public MoveThread(Zombie c2,Location lo,int[][] map,Cursor cursor){
			this.c = c2;
			this.lo = lo;
			this.map = map;
		}
		
		public void run(){
			c.moveForward(map, lo);
		}
	}
}
