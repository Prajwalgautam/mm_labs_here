import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Frame;
import java.awt.geom.AffineTransform;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Shape;
class Transformation extends Frame{
 
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawRect(30,50,60,60);
		AffineTransform tx1 = new AffineTransform();
        tx1.translate(100, 90);
        tx1.shear(0, 1);
    	g2d.setTransform(tx1);
    	g2d.draw(new Rectangle(0, 0, 80, 50));
 
    	AffineTransform tx2 = new AffineTransform();
        tx2.translate(200, 200);
        tx2.rotate(30.0);
    	g2d.setTransform(tx2);
    	g2d.draw(new Rectangle(0, 0, 80, 50));
 
    	AffineTransform tx3 = new AffineTransform();
        tx3.translate(300, 200);
        tx3.scale(3,2);
    	g2d.setTransform(tx3);
    	g2d.draw(new Rectangle(0, 0, 80, 50));
	}
 
	public Transformation(){
		setLayout(null);
		setVisible(true);
		setSize(400,400);
	}
	public static void main(String args[]){
		new Transformation();
	}
}