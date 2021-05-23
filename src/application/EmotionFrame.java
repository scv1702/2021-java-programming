package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.*;

public class EmotionFrame extends JFrame {
	
	public EmotionFrame() {
		Font font = new Font("³ª´®°íµñ", Font.PLAIN, 20);
		JFrame frm=new JFrame("Emotion");
		frm.setSize(500,400);
		frm.setLocationRelativeTo(null);
		frm.getContentPane().setLayout(null);
		frm.setResizable(false);
		frm.getContentPane().setBackground(Color.WHITE);
		JLabel lab=new JLabel();
		lab.setBounds(170,20,500,50);
		lab.setText("Emotion selection");
		lab.setFont(font);
		frm.getContentPane().add(lab);
		JButton [] btn= {new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton()};
		int x=75;
		int y=100;
		for(int i=0;i<btn.length;i++) {
			btn[i].setBounds(x, y, 100, 100);
			btn[i].setBorderPainted(false);
			btn[i].setContentAreaFilled(false);
			frm.getContentPane().add(btn[i]);
			x+=130;
			if(i%3==2) {
				y+=120;
				x=75;
			}
		}
		ImageIcon[] img= {new ImageIcon("./data/images/mood/happy.png"),new ImageIcon("./data/images/mood/good.png"),new ImageIcon("./data/images/mood/tired.png"),
						  new ImageIcon("./data/images/mood/bad.png"),new ImageIcon("./data/images/mood/sad.png"),new ImageIcon("./data/images/mood/sick.png")};
		for(int i=0;i<img.length;i++) {
			Image temp=img[i].getImage();
			Image change=temp.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			ImageIcon tempicon=new ImageIcon(change);
			btn[i].setIcon(tempicon);
		}
		
		frm.setVisible(true);
	    
	}
}