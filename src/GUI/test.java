package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class test implements KeyListener {

	public static void main(String[] args) {
		JFrame jf = new JFrame("JFrame");
		jf.setLayout(new BorderLayout());
		
		
		JButton jb = new JButton("JButton");
		jb.setPreferredSize(new Dimension(200, 100));
		jf.add(jb, BorderLayout.SOUTH);
		
		JPanel jp2 = new JPanel();
		jp2.add(new JLabel("JPanel"));
		jp2.setPreferredSize(new Dimension(100, 200));
		jp2.setBorder(BorderFactory.createLineBorder(Color.black));
		jf.add(jp2, BorderLayout.WEST);
		
		JPanel jp3 = new JPanel();
		jp3.add(new JLabel("JPanel"));
		jp3.setPreferredSize(new Dimension(100, 200));
		jp3.setBorder(BorderFactory.createLineBorder(Color.black));
		jf.add(jp3, BorderLayout.EAST);
		
		JPanel jp = new JPanel();
		JLabel jl = new JLabel("JLabel in JPanel");
		jl.setBorder(BorderFactory.createLineBorder(Color.black));
		
		jp.add(jl);
		jp.setPreferredSize(new Dimension(200, 200));
		jp.setBorder(BorderFactory.createLineBorder(Color.black));
		jf.add(jp);
		
		JTextArea ja = new JTextArea("JTextArea");
		ja.setPreferredSize(new Dimension(200, 100));
		jf.add(ja, BorderLayout.NORTH);
		
		
		
		jf.show();
		jf.pack();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		e.getKeyChar();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
