package maps.main;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

import maps.gamestate.MapsStateManager;
import maps.resources.Images;

public class MapsPanel extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{
	private static final long serialVersionUID = 1L;
	
	//The width and height of the main panel
	public static final int WIDTH = 900;
	public static final int HEIGHT = 700;
	
	//The thread that keeps the whole thing running.
	private Thread thread;
	private boolean isRunning = false;
	
	private int FPS = 60;
	private long targetTime = 1000/FPS;
	
	private MapsStateManager msm;
	
	public MapsPanel(){
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		addKeyListener(this);
		setFocusable(true);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		new Images();
		
		start();
	}
	
	/**
	 * The start method, begins the thread, and sets the game to running.
	 */
	private void start(){
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		msm.mouseMoved(e.getX(), e.getY());
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		msm.mouseClicked(e.getX(), e.getY());
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		msm.keyPressed(e.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		msm.keyReleased(e.getKeyCode());
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		long start, elapsed, wait;
		
		msm = new MapsStateManager();
		
		while(isRunning) {
			start = System.nanoTime();
			
			tick();
			repaint();
			
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;
			
			if(wait <= 0){
				wait = 5;
			}
			
			try{
				Thread.sleep(wait);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void tick(){
		msm.tick();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		msm.draw(g);
	}
}
