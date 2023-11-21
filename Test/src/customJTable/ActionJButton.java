package customJTable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class ActionJButton extends JButton{
	
	private boolean mousePress;
	
	public ActionJButton() {
		setContentAreaFilled(false);
		setBorder(new EmptyBorder(3, 3, 3, 3));
		setFocusPainted(false);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				mousePress = true;
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				mousePress = false;
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int width = this.getWidth();
		int heigth = this.getHeight();
		int size = Math.min(width, heigth);
		int x = (width - size)/2;
		int y = (heigth - size)/2;
		if(mousePress) {
			g2.setColor(new Color(158,158,158));
		} else {
			g2.setColor(new Color(199,199,199));
		}
		g2.fill(new Ellipse2D.Double(x,y,size,size));
		g2.dispose();
		super.paintComponent(g);
	}
}
