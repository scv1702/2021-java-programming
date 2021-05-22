/*
 * 새로운 일정을 추가하는 프레임을 띄우는 클래스
 * 작성자: 이윤서
 */

package application;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class MakeAddPlanFrame extends Main {
	JFrame AddPlanFrame = new JFrame();

	private JTextField planName;
	private JTextField year;
	private JTextField month;
	private JTextField day;
	private JTextField startHour;
	private JTextField startMin;
	private JTextField finishHour;
	private JTextField finishMin;
	
	public MakeAddPlanFrame() {
		AddPlanFrame.setTitle("Add your Plan");
		AddPlanFrame.setVisible(true);
		AddPlanFrame.setResizable(false);
		
		ImagePanel AddPlanPanel = new ImagePanel(new ImageIcon(new File("./data/images/panel_page/AddPlanPanel.png").getAbsolutePath()).getImage());
		AddPlanFrame.setSize(AddPlanPanel.getDim());
		AddPlanFrame.setPreferredSize(AddPlanPanel.getDim());
		AddPlanFrame.getContentPane().add(AddPlanPanel);
		AddPlanFrame.setLocationRelativeTo(null);
	
		planName = new JTextField() {
			@Override
			public void setBorder(Border border) {
				
			}
		};
		
		planName.setFont(new Font("NanumSquare", Font.PLAIN, 34));
		planName.setBounds(32, 47, 452, 70);
		planName.setColumns(10);
		planName.setOpaque(false);
		planName.setHorizontalAlignment(JTextField.CENTER);
		
		AddPlanPanel.add(planName);
		
		year = new JTextField(){
			@Override
			public void setBorder(Border border) {
				
			}
		};	
		
		year.setToolTipText("4");
		year.setFont(new Font("NanumSquareOTF", Font.PLAIN, 24));
		year.setBounds(68, 146, 111, 46);
		year.setColumns(10);
		year.setOpaque(false);
		year.setDocument(new jTextFieldLimit(4));
		year.setHorizontalAlignment(JTextField.CENTER);
		
		AddPlanPanel.add(year);

		month = new JTextField(){
			@Override
			public void setBorder(Border border) {
				
			}
		};	
		
		month.setFont(new Font("NanumSquare", Font.PLAIN, 24));
		month.setBounds(226, 146, 57, 46);
		month.setColumns(10);
		month.setOpaque(false);
		month.setDocument(new jTextFieldLimit(2));
		month.setHorizontalAlignment(JTextField.CENTER);
		
		AddPlanPanel.add(month);
		
		day = new JTextField(){
			@Override
			public void setBorder(Border border) {
				
			}
		};	
		
		day.setFont(new Font("NanumSquareOTF", Font.PLAIN, 24));
		day.setBounds(340, 146, 57, 46);
		day.setColumns(10);
		day.setOpaque(false);
		day.setDocument(new jTextFieldLimit(2));
		day.setHorizontalAlignment(JTextField.CENTER);
		
		AddPlanPanel.add(day);
		
		startHour = new JTextField(){
			@Override
			public void setBorder(Border border) {
				
			}
		};
		
		startHour.setFont(new Font("NanumSquareOTF", Font.PLAIN, 24));
		startHour.setBounds(43, 217, 57, 47);
		startHour.setColumns(10);
		startHour.setOpaque(false);
		startHour.setDocument(new jTextFieldLimit(2));
		startHour.setHorizontalAlignment(JTextField.CENTER);
		
		AddPlanPanel.add(startHour);
		
		startMin = new JTextField(){
			@Override
			public void setBorder(Border border) {
				
			}
		};
		
		startMin.setFont(new Font("NanumSquareOTF", Font.PLAIN, 24));
		startMin.setBounds(139, 219, 57, 46);	
		startMin.setColumns(10);
		startMin.setOpaque(false);
		startMin.setDocument(new jTextFieldLimit(2));
		startMin.setHorizontalAlignment(JTextField.CENTER);
		
		AddPlanPanel.add(startMin);
		
		finishHour = new JTextField(){
			@Override
			public void setBorder(Border border) {
				
			}
		};
		
		finishHour.setFont(new Font("NanumSquareOTF", Font.PLAIN, 24));
		finishHour.setBounds(282, 218, 57, 47);
		finishHour.setColumns(10);
		finishHour.setOpaque(false);
		finishHour.setDocument(new jTextFieldLimit(2));
		finishHour.setHorizontalAlignment(JTextField.CENTER);
		
		AddPlanPanel.add(finishHour);
		
		finishMin = new JTextField(){
			@Override
			public void setBorder(Border border) {
				
			}
		};
		
		finishMin.setHorizontalAlignment(JTextField.CENTER);
		finishMin.setFont(new Font("NanumSquareOTF", Font.PLAIN, 24));
		finishMin.setBounds(378, 219, 57, 46);
		finishMin.setColumns(10);
		finishMin.setDocument(new jTextFieldLimit(2));
		finishMin.setOpaque(false);
		
		AddPlanPanel.add(finishMin);
		
		JButton planSavebtn = new JButton("");
		planSavebtn.setBorderPainted(false);
		planSavebtn.setBounds(215, 598, 97, 46);
		planSavebtn.setOpaque(false);
		AddPlanPanel.add(planSavebtn);
		
		planSavebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String _content = planName.getText();
				
				int _year = Integer.parseInt(year.getText());
				int _month = Integer.parseInt(month.getText());
				int _day = Integer.parseInt(day.getText());
				
				int _startHour = Integer.parseInt(startHour.getText());
				int _startMin = Integer.parseInt(startMin.getText());
				
				int _finishHour = Integer.parseInt(finishHour.getText());
				int _finishMin = Integer.parseInt(finishMin.getText());

				try {
					DB.addScheduleToDB(new Day(_year, _month, _day), new Schedule(_content, _startHour, _startMin, _finishHour, _finishMin));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				/* 창 종료 */
				AddPlanFrame.dispose();
				
			}
		});
	}
}
