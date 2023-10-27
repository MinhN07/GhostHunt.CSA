import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Car{
	private Image img; 	
	private AffineTransform tx;
	int width, height;
	static int x;						//position of the object
	int y;
	int vx, vy;						//movement variables
	double scaleWidth = 4.2;		 //change to scale image
	double scaleHeight = 4.2; //change to scale image

	public Car(String filename) {
		img = getImage("/imgs/"+filename); //load the image for Tree

		//alter these
		width = 100;
		height = 2;
		x = 50;
		y = 340;
		vx = 4;
		vy = 0;
		
		
		
		tx = AffineTransform.getTranslateInstance(0, 0);
		init(x, y); 				//initialize the location of the image
									//use your variables
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(0, 0);
	}
	
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		
		if(x > 750) {
			Car.x = -500; 
			vx = 4;
		}

		
		x+=vx;
		y+=vy;
		
	
			

		
		init(x,y);
		g2.drawImage(img, tx, null);

	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(scaleWidth, scaleHeight);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Car.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
