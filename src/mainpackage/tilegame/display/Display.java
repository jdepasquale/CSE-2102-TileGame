package mainpackage.tilegame.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	
	private JFrame frame;
	private Canvas canvas;
	//public int x = 0;
	private String title;
	private int width;
	private int height;
	
	public Display(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		
		creatDisplay();
	}
	
	private void creatDisplay(){
		frame = new JFrame(title);
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); //user can't change window size
		frame.setLocationRelativeTo(null); // display appears in middle of screen
		frame.setVisible(true); // display can now be seen
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height)); // set size of canvas we want
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		
		frame.add(canvas); //add canvas to frame
		frame.pack(); // resizes window to show full canvas
	}
	
	public Canvas getCanvas(){
		return canvas;
	}
	
}
