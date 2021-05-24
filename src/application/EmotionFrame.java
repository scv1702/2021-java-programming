package application;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import java.io.FileWriter;
import java.io.File;

import java.io.BufferedWriter;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;


public class EmotionFrame extends JFrame {
	
	public EmotionFrame(String day) {
		
		Font font = new Font("나눔 고딕", Font.PLAIN, 20);

        JFrame frm = new JFrame("Emotion");
        frm.setSize(500, 400);
        frm.setLocationRelativeTo(null);
        frm.getContentPane().setLayout(null);
        frm.setResizable(false);
        frm.getContentPane().setBackground(Color.WHITE);
        JLabel lab = new JLabel();
        lab.setBounds(170,20,500,50);
        lab.setText("Emotion selection");
        lab.setFont(font);
        frm.getContentPane().add(lab);
        JButton [] btn = {new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton()};
        
        int x = 75;
        int y = 100;
        for(int i = 0; i < btn.length; i++) {
        btn[i].setBounds(x, y, 100, 100);
            btn[i].setBorderPainted(false);
            btn[i].setContentAreaFilled(false);
            frm.getContentPane().add(btn[i]);
            x += 130;
            if(i % 3 == 2) {
                y += 120;
                x = 75;
            }
        }
        
        ImageIcon[] img = { new ImageIcon("./data/images/mood/happy.png"), new ImageIcon("./data/images/mood/good.png"), new ImageIcon("./data/images/mood/tired.png"),
        new ImageIcon("./data/images/mood/bad.png"), new ImageIcon("./data/images/mood/sad.png"), new ImageIcon("./data/images/mood/sick.png") };
        
        for(int i = 0; i < img.length; i++) {
            Image temp = img[i].getImage();
            Image change = temp.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon tempicon = new ImageIcon(change);
            btn[i].setIcon(tempicon);
        }
        
        // happy (0)
        btn[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    File file = new File("./data/moodDB/" + day +".txt");
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                    if(file.isFile() && file.canWrite()) {
                        bufferedWriter.write("0");
                        bufferedWriter.close();
                    }
                }
                catch (IOException e) {
                    System.out.println(e);
                }
                frm.dispose();
            }
        });
        
        // good (1)
        btn[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    File file = new File("./data/moodDB/" + day +".txt");
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                    if(file.isFile() && file.canWrite()) {
                        bufferedWriter.write("1");
                        bufferedWriter.close();
                    }
                }
                catch (IOException e) {
                    System.out.println(e);
                }
                frm.dispose();
            }
        });
        
        // tired (2)
        btn[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    File file = new File("./data/moodDB/" + day +".txt");
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                    if(file.isFile() && file.canWrite()) {
                        bufferedWriter.write("2");
                        bufferedWriter.close();
                    }
                }
                catch (IOException e) {
                    System.out.println(e);
                }
                frm.dispose();
            }
        });
        
        // bad (3)
        btn[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    File file = new File("./data/moodDB/" + day +".txt");
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                    if(file.isFile() && file.canWrite()) {
                        bufferedWriter.write("3");
                        bufferedWriter.close();
                    }
                }
                catch (IOException e) {
                    System.out.println(e);
                }
                frm.dispose();
            }
        });
        
        // sad (4)
        btn[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    File file = new File("./data/moodDB/" + day +".txt");
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                    if(file.isFile() && file.canWrite()) {
                        bufferedWriter.write("4");
                        bufferedWriter.close();
                    }
                }
                catch (IOException e) {
                    System.out.println(e);
                }
                frm.dispose();
            }
        });
        
        // sick (5)
        btn[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    File file = new File("./data/moodDB/" + day +".txt");
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                    if(file.isFile() && file.canWrite()) {
                        bufferedWriter.write("5");
                        bufferedWriter.close();
                    }
                }
                catch (IOException e) {
                    System.out.println(e);
                }
                frm.dispose();
            }
        });
        
        
        frm.setVisible(true);
	}
	
}