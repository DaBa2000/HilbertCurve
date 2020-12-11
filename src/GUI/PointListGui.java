package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Structural.HilbertCurve;
import Structural.Point;

public class PointListGui extends JPanel implements KeyListener {

	HilbertCurve curve;
	boolean showNu = false;
	
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame();
		PointListGui plg = new PointListGui();
		
		mainFrame.add(plg);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setVisible(true);
	}
	
	public PointListGui() {
		this.setPreferredSize(new Dimension(1000, 1000));
		this.addKeyListener(this);
		this.setVisible(true);
		this.setFocusable(true);
		
		setBackground(Color.WHITE);
		
		curve = new HilbertCurve();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		g2d.setStroke(new BasicStroke(3));
		
		List<Point> pointList = curve.getCurve();
		int length = curve.getSideLength();
		
		int x_center = (int) this.getSize().getWidth()/2;
		int y_center = (int) this.getSize().getHeight()/2;
		
		double pointDiff = 800.0/length;
		
		for (int i = 0; i < pointList.size(); i++) {
			
			double x = pointList.get(i).getX();
			double y = pointList.get(i).getY();
			int radius = pointList.get(i).getRadius();
			
			x = ((x*pointDiff) + x_center -400);
			y = ((y*pointDiff) + y_center -400);
			y = y + 2*(y_center - y);
			
			if (i != pointList.size()-1) {
				double x_next = pointList.get(i+1).getX();
				double y_next = pointList.get(i+1).getY();
				
				x_next = ((x_next*pointDiff) + x_center -400);
				y_next = ((y_next*pointDiff) + y_center -400);
				y_next = y_next + 2*(y_center - y_next);
				
				g2d.drawLine((int) x, (int) y, (int) x_next, (int) y_next);
				try {
					TimeUnit.MILLISECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.revalidate();
			}
			
			//if (pointList.size() < 100) g.fillOval((int) x -radius, (int) y - radius, 2*radius, 2*radius);
			if (showNu) g2d.drawString(""+i, (int) x+5, (int) y-5);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			curve.step();
			this.repaint();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			curve.stepBack();
			this.repaint();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_N) {
			showNu = !showNu;
			this.repaint();
		}
	}
}
