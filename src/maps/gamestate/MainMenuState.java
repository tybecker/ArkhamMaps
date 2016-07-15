package maps.gamestate;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenuState extends MapsState{

	private String[] options = {"Map Generation","Help","Exit"};
	private int currentSelection = 0;

	public MainMenuState(MapsStateManager msm){
		super(msm);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		for(int i = 0; i < options.length; i++){
			if(i == currentSelection){
				g.setColor(Color.BLUE);
			}else{
				g.setColor(Color.BLACK);
			}
			
			g.setFont(new Font("Arial", Font.PLAIN, 36));
			g.drawString(options[i], 50, 70 + i* 50);
		}
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		if(k == KeyEvent.VK_DOWN){
			currentSelection++;
			if(currentSelection >= options.length){
				currentSelection = 0;
			}
		//If the up key is pressed, move the selection up one. 
		}else if (k == KeyEvent.VK_UP){
			currentSelection--;
			if(currentSelection < 0){
				currentSelection = options.length - 1;
			}
		}
		//If the enter key is pressed, activate the option associated with the
		//current selection
		if(k == KeyEvent.VK_ENTER){
			if(currentSelection  == 0){
				msm.states.push(new AlgSelectionState(msm));
			}else if(currentSelection == 1){
				JFrame aboutFrame = new JFrame("About");
				aboutFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				aboutFrame.setResizable(false);
				aboutFrame.setLayout(new BorderLayout());
				
				JPanel aboutPanel = new JPanel();
				aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.PAGE_AXIS));
				aboutPanel.setSize(300, 300);
				
				JLabel aboutLabel = new JLabel("Alright, so here's the deal.  This isn't part of the \"Magical Girl Princess Cthulhu\" game.");
				aboutPanel.add(aboutLabel);
				JLabel aboutLabel2 = new JLabel("This is just something I whipped up to test map algorithms, and determine whether it was ");
				aboutPanel.add(aboutLabel2);
				JLabel aboutLabel3 = new JLabel("an algorithm we wanted.  Quite frankly, I feel beyond my ability to come up with decent");
				aboutPanel.add(aboutLabel3);
				JLabel aboutLabel4 = new JLabel("algorithms out of my head, so having them down in code could be just what I need.  Now");
				aboutPanel.add(aboutLabel4);
				JLabel aboutLabel5 = new JLabel("what are you waiting for?  Go to map generation, click on an algorithm, and get started!");
				aboutPanel.add(aboutLabel5);
				
				aboutFrame.add(aboutPanel, BorderLayout.CENTER);
				aboutFrame.pack();
				aboutFrame.setLocationRelativeTo(null);
				aboutFrame.setVisible(true);
			}else if(currentSelection == 2){
				System.exit(0);
			}
		}
	}

	@Override
	public void keyReleased(int k) {
		
	}

	@Override
	public void mouseMoved(int x, int y) {
		if(x >= 50 && x <= 242 && y >= 42 && y <= 70){
			currentSelection = 0;
		}else if(x >= 50 && x <= 150 && y >= 92 && y <= 120){
			currentSelection = 1;
		}else if(x >= 50 && x <= 150 && y >= 142 && y <= 170){
			currentSelection = 2;
		}
	}

	@Override
	public void mouseClicked(int x, int y) {
		this.keyPressed(KeyEvent.VK_ENTER);
	}
}
