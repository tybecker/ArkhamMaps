package maps.main;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Maps {
	//The main method.  Most of the good stuff is in the maps panel though.
		public static void main(String [] args){
			JFrame frame = new JFrame("Maps of Arkham");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.setLayout(new BorderLayout());
			frame.add(new MapsPanel(), BorderLayout.CENTER);
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		}
}
