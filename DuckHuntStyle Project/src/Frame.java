import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	
	//Timer related variables
	int waveTimer = 20; 
	long ellapseTime = 0; 
	Font timeFont = new Font("Courier",Font.BOLD, 70); 
	String Losing =  "You Lose!"; 
	//frame width/height
	int width = 800;
	int height = 800;
	
	int score = 0; 
	
	
	//Add your object declaration and instantiations here
	Background b = new Background("BackgroundHot.gif");
	Ghost ghostA = new Ghost("New Ghost.png");  
	UFO UFOA = new UFO("UFO.png"); 
	Car CarA = new Car("Car1.png"); 
	Bus BusA = new Bus("Bus.gif");
	Score ScoreA = new Score("Score.png");
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		//Call the paint method of your objects here
		b.paint(g);
		UFOA.paint(g);
		CarA.paint(g);
		BusA.paint(g);
		ghostA.paint(g);
		ScoreA.paint(g);
		
		//Wave Timer
		g.setFont(timeFont); 
		g.drawString(""+waveTimer, 675, 738); 
		//Update time
		
		
		ellapseTime += 20; 
		if(ellapseTime % 1000 == 0 ) {
			waveTimer -- ; 
		ellapseTime=0;
		if(waveTimer <0) {
			waveTimer ++;
		}
		//Ghost wont work until passed level 
		}
		
		
		
		
		Font f = new Font("Courier", Font.BOLD,60); 
		g.setFont(f);
		
		g.setColor(Color.WHITE); 
		g.drawString("" + score , 235,735); 
		
		if(waveTimer == 0 && score < 10) {
			g.setColor(Color.black);
			g.drawString(""+Losing, 250, 450);
			
		}
		
		
	}
	

	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("Duck Hunt");
		f.setSize(new Dimension(width, height));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
 		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void mousePressed(MouseEvent m) {
		System.out.println("press event block of code");
		System.out.println(m.getX() + ":" +m.getY());
		
		System.out.println(ghostA.x+":"+ghostA.y);
		System.out.println(ghostA.width + ":" + ghostA.height);
		
		//rectangle collision
		Rectangle a = new Rectangle (m.getX(),m.getY(),50,50); //x,y,width, height
		
		//rectangle representation of ghost object
		Rectangle b = new Rectangle(ghostA.x, ghostA.y, ghostA.width, ghostA.height ); 
		
		
		//check for collision  using the intersect method 
		if(a.intersects(b)) {
			System.out.println("ouch!");
			score ++; 
			
			
		//let's fake respawn by teleporting object back to the some starting value positions
			ghostA.x = 50;
			ghostA.y = 50;
			
			ghostA.x = (int)(Math.random()*(650+1)+5); // reset : will vary per gameplay/student
			ghostA.y = (int)(Math.random()*(600+1)+0);
			ghostA.vx = (int)(Math.random()*(5+1)+3);
			ghostA.vy = (int)(Math.random()*(5+1)+3);
			if(Math.random()<.5) {
				ghostA.vx *= -1;
			}
			if(Math.random()<.5) {
				ghostA.vy *= -1;
			}

			
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
