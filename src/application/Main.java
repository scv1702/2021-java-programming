package application;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

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

public class Main {
	public static JFrame frame;
	public static JButton UpdatePlanbtn;
	
	// �뀒�뒪�듃1
	// �씠�쑄�꽌 諛붾낫

	/* Create the application. */
	public Main() {
		initialize();
	}

	public static void initialize() {
		Audio audio = new Audio("schedule-initial");
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		frame.setTitle("Knu Daily, Kaily");
		
		ImageIcon clickTracker = new ImageIcon("./data/images/Icon/Tracker_click_line.png");
		ImageIcon clickPlan = new ImageIcon("./data/images/Icon/Plan_click_line.png");
		ImageIcon clickMood = new ImageIcon("./data/images/Icon/Mood_click_line.png");
		
		ImagePanel startPanel = new ImagePanel(new ImageIcon("./data/images/panel_page/Kaily_start.png").getImage());
		ImagePanel menuPanel = new ImagePanel(new ImageIcon("./data/images/panel_page/Kaily_menu.png").getImage());
		ImagePanel MoodPanel = new ImagePanel(new ImageIcon("./data/images/panel_page/MoodPanel.png").getImage());
		ImagePanel TrackerPanel = new ImagePanel(new ImageIcon("./data/images/panel_page/TrackerPanel.png").getImage());
		ImagePanel monthlyTrackerPanel = new ImagePanel(new ImageIcon("./data/images/panel_page/Tracker_monthly_panel.png").getImage());
		ImagePanel dailyTrackerPanel = new ImagePanel(new ImageIcon("./data/images/panel_page/Tracker_daily_panel.png").getImage());
		ImagePanel PlanPanel =  new ImagePanel(new ImageIcon("./data/images/panel_page/PlanPanel.png").getImage());
		
		ImageIcon PlayIcon = new ImageIcon("./data/images/Icon/play.png");
		ImageIcon PauseIcon = new ImageIcon("./data/images/Icon/Pause.png");

		JButton plangoToMenubtn = new JButton("");
		JButton AddPlanbtn = new JButton("");
		JButton goToMenu = new JButton("�떦�떊�쓽 �븯猷⑤�� �븿猿섑븯�뒗 鍮꾩꽌, Kaily.");
		JButton Planbtn = new JButton("");
		JButton Trackerbtn = new JButton("");
		JButton Moodbtn = new JButton("");
		JButton moodgoToMenubtn = new JButton("");
		JButton trackergoToMenubtn = new JButton("");
		JButton goToDailyTrackerbtn = new JButton("");
		JButton goToMonthlyTracker = new JButton("");
		JButton monthlyToTracker = new JButton("");
		JButton dailyToTracker = new JButton("");
		JTextPane PlanPrintPanel = new JTextPane();
		UpdatePlanbtn = new JButton("");
		JButton Deletebtn = new JButton("");
		JButton Backbtn = new JButton("");
		JButton Playbtn = new JButton("");
		JButton Forwardbtn = new JButton("");
		JButton selectMonthbtn = new JButton("");
		
		AddPlanbtn.setIcon(new ImageIcon("./data/images/Icon/Add.png"));
		Planbtn.setIcon(new ImageIcon("./data/images/Icon/Plan.png"));
		Trackerbtn.setIcon(new ImageIcon("./data/images/Icon/Tracker.png"));
		Moodbtn.setIcon(new ImageIcon("./data/images/Icon/Mood.png"));
		Deletebtn.setIcon(new ImageIcon("./data/images/Icon/delete.png"));
		Backbtn.setIcon(new ImageIcon("./data/images/Icon/back.png"));
		Forwardbtn.setIcon(new ImageIcon("./data/images/Icon/fast-forward.png"));
		UpdatePlanbtn.setIcon(new ImageIcon("./data/images/Icon/Update.png"));
		
//		ImageIcon clickTracker = new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/Tracker_click_line.png");
//		ImageIcon clickPlan = new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/Plan_click_line.png");
//		ImageIcon clickMood = new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/Mood_click_line.png");
//		ImagePanel startPanel = new ImagePanel(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/panel_page/Kaily_start.png").getImage());
//		ImagePanel menuPanel = new ImagePanel(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/panel_page/Kaily_menu.png").getImage());
//		ImagePanel MoodPanel = new ImagePanel(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/panel_page/MoodPanel.png").getImage());
//		ImagePanel TrackerPanel = new ImagePanel(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/panel_page/TrackerPanel.png").getImage());
//		ImagePanel monthlyTrackerPanel = new ImagePanel(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/panel_page/Tracker_monthly_panel.png").getImage());
//		ImagePanel dailyTrackerPanel = new ImagePanel(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/panel_page/Tracker_daily_panel.png").getImage());
//		ImagePanel PlanPanel = new ImagePanel(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/panel_page/PlanPanel.png").getImage());
//		ImageIcon PlayIcon = new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/play.png");
//		ImageIcon PauseIcon = new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/Pause.png");
		
//		AddPlanbtn.setIcon(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/Add.png"));
//		Planbtn.setIcon(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/Plan.png"));
//		Trackerbtn.setIcon(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/Tracker.png"));
//		Moodbtn.setIcon(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/Mood.png"));
//		Deletebtn.setIcon(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/delete.png"));
//		Backbtn.setIcon(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/back.png"));
//		Forwardbtn.setIcon(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/fast-forward.png"));
//		UpdatePlanbtn.setIcon(new ImageIcon("/Users/ellie/Desktop/2021-java-programming/data/images/Icon/Update.png"));
		
		menuPanel.setVisible(false);
		MoodPanel.setVisible(false);
		TrackerPanel.setVisible(false);
		monthlyTrackerPanel.setVisible(false);
		dailyTrackerPanel.setVisible(false);
		
		PlanPanel.setVisible(false);
		frame.getContentPane().add(PlanPanel);
		PlanPanel.setLayout(null);
		
		plangoToMenubtn.setBounds(1215, 25, 48, 46);
		plangoToMenubtn.setBorderPainted(false);
		plangoToMenubtn.setContentAreaFilled(false);
		PlanPanel.add(plangoToMenubtn);
		
		plangoToMenubtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlanPanel.setVisible(false);
				menuPanel.setVisible(true);
			}	
		});

		AddPlanbtn.setBounds(365, 611, 61, 56);
		AddPlanbtn.setBorderPainted(false);
		PlanPanel.add(AddPlanbtn);
		
		AddPlanbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MakeAddPlanFrame();
			}
		});

		frame.getContentPane().add(startPanel);
		frame.getContentPane().add(menuPanel);
		frame.getContentPane().add(MoodPanel);
		frame.getContentPane().add(TrackerPanel);
		frame.getContentPane().add(dailyTrackerPanel);
		frame.getContentPane().add(monthlyTrackerPanel);
	
		frame.setSize(startPanel.getDim());
		frame.setPreferredSize(startPanel.getDim());

		goToMenu.setBounds(431, 402, 483, 71);
		startPanel.add(goToMenu);
		goToMenu.setBorderPainted(false);
		goToMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startPanel.setVisible(false);
				menuPanel.setVisible(true);
			}		
		});
		goToMenu.setFont(new Font("�굹�닎�넀湲��뵪 媛��엺�뿰苑�", Font.PLAIN, 24));
		
		Planbtn.setBorderPainted(false);

		Planbtn.setBounds(586, 58, 133, 84);
		Planbtn.setRolloverIcon(clickPlan);
		menuPanel.add(Planbtn);
		
		Planbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(false);
				PlanPanel.setVisible(true);
			}
		});
		
		Trackerbtn.setBorderPainted(false);

		Trackerbtn.setBounds(334, 484, 165, 63);
		Trackerbtn.setRolloverIcon(clickTracker);
		menuPanel.add(Trackerbtn);
		
		Trackerbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(false);
				TrackerPanel.setVisible(true);
			}
		});
		
		Moodbtn.setBorderPainted(false);

		Moodbtn.setBounds(809, 484, 165, 63);
		Moodbtn.setRolloverIcon(clickMood);
		menuPanel.add(Moodbtn);
		
		Moodbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(false);
				MoodPanel.setVisible(true);
			}
		});
		
		moodgoToMenubtn.setBounds(1214, 22, 48, 46);
		moodgoToMenubtn.setBorderPainted(false);
		moodgoToMenubtn.setContentAreaFilled(false);
		MoodPanel.add(moodgoToMenubtn);
		
		moodgoToMenubtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MoodPanel.setVisible(false);
				menuPanel.setVisible(true);
			}	
		});
		
		trackergoToMenubtn.setBounds(1213, 23, 48, 46);
		trackergoToMenubtn.setBorderPainted(false);
		trackergoToMenubtn.setContentAreaFilled(false);
		TrackerPanel.add(trackergoToMenubtn);
	
		trackergoToMenubtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TrackerPanel.setVisible(false);
				menuPanel.setVisible(true);
			}	
		});
		
		goToDailyTrackerbtn.setBounds(224, 305, 193, 101);
		goToDailyTrackerbtn.setBorderPainted(false);
		goToDailyTrackerbtn.setContentAreaFilled(false);
		TrackerPanel.add(goToDailyTrackerbtn);
		
		goToDailyTrackerbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TrackerPanel.setVisible(false);
				dailyTrackerPanel.setVisible(true);
				
			}	
		});
		
		goToMonthlyTracker.setBounds(798, 305, 238, 101);
		goToMonthlyTracker.setBorderPainted(false);
		goToMonthlyTracker.setContentAreaFilled(false);
		TrackerPanel.add(goToMonthlyTracker);
		
		goToMonthlyTracker.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TrackerPanel.setVisible(false);
				monthlyTrackerPanel.setVisible(true);
				
			}	
		});
		
		monthlyToTracker.setBounds(63, 357, 70, 60);
		monthlyToTracker.setBorderPainted(false);
		monthlyToTracker.setContentAreaFilled(false);
		monthlyTrackerPanel.add(monthlyToTracker);
		
		monthlyToTracker.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				monthlyTrackerPanel.setVisible(false);
				TrackerPanel.setVisible(true);
			}
		});
		
		dailyToTracker.setBounds(67, 366, 64, 48);
		dailyToTracker.setBorderPainted(false);
		dailyToTracker.setContentAreaFilled(false);
		dailyTrackerPanel.add(dailyToTracker);
		
		dailyToTracker.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dailyTrackerPanel.setVisible(false);
				TrackerPanel.setVisible(true);
			}
		});
		
		PlanPrintPanel.setContentType("text/html");
		PlanPrintPanel.setEditable(false);
		JScrollPane ScrollPrint = new JScrollPane(PlanPrintPanel) {
			public void setBorder(Border border) {
				
			}
		};
		ScrollPrint.setBounds(365, 90, 773, 509);
		
		PlanPrintPanel.setEditable(false);
		PlanPrintPanel.setBounds(336, 90, 790, 509);
		PlanPanel.add(ScrollPrint,BorderLayout.CENTER);
		
		StyledDocument doc = PlanPrintPanel.getStyledDocument();
		SimpleAttributeSet styleSet = new SimpleAttributeSet();
	    StyleConstants.setFontSize(styleSet, 20);
	    
		UpdatePlanbtn.setBounds(438, 611, 66, 56);
		PlanPanel.add(UpdatePlanbtn);
		UpdatePlanbtn.setBorderPainted(false);
		
		Deletebtn.setBounds(516, 611, 61, 63);
		Deletebtn.setBorderPainted(false);
		PlanPanel.add(Deletebtn);
		
		Backbtn.setBounds(76, 351, 48, 46);
		PlanPanel.add(Backbtn);
		Backbtn.setBorderPainted(false);
				
		Playbtn.setIcon(PlayIcon);
		Playbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (audio.isPlay == true) {
					audio.stop();
					Playbtn.setIcon(PlayIcon);
				} else {
					Playbtn.setIcon(PauseIcon);
					audio.play();
					
				}
			}
		});
		
		Playbtn.setBounds(152, 349, 48, 48);
		PlanPanel.add(Playbtn);
		Playbtn.setBorderPainted(false);
	
		Forwardbtn.setBounds(229, 351, 48, 46);
		PlanPanel.add(Forwardbtn);
		Forwardbtn.setBorderPainted(false);
		
		UpdatePlanbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = "";
				PlanPrintPanel.setText("");
				try {
					DB.updateDayDB();
				} catch (IOException e2) {
					System.out.println(e2);
				}
				
				try {
					HTMLEditorKit kit = new HTMLEditorKit();
					HTMLDocument HtmlDoc = new HTMLDocument();
					
					PlanPrintPanel.setEditorKit(kit);
					PlanPrintPanel.setDocument(HtmlDoc);
					
					for (Day d : DB.dayDB) {
						text += DB.searchScheduleList(d);
						kit.insertHTML(HtmlDoc, HtmlDoc.getLength(),"<p style='font-family: �굹�닎�넀湲��뵪 媛��엺�뿰苑�; font-size: 25px; color: #323C73; font-weight: bold; font-style: italic;'>" + d + "</p>", 0, 0, null);
						kit.insertHTML(HtmlDoc, HtmlDoc.getLength(), "<p><hr align='left' width ='200px'></p>", 0, 0, null);
						for (Schedule s : DB.searchScheduleList(d).scheduleList) {
							String output = String.format("%02d : %02d ~ %02d : %02d %s", s.getStartHour(), s.getStartMin(), s.getFinishHour(), s.getFinishMin(), s.getContent());
							kit.insertHTML(HtmlDoc, HtmlDoc.getLength(), "<font size='6px'> <br> </font>", 0, 0, null);
							kit.insertHTML(HtmlDoc, HtmlDoc.getLength(), "<p style='font-family: �굹�닎�넀湲��뵪 媛��엺�뿰苑�; font-size: 20px; color: black;'>" + output + "</p>", 0, 0, null);
						}
						kit.insertHTML(HtmlDoc, HtmlDoc.getLength(), "<font size='20px'><br><br><br></font>", 0, 0, null);
						Util.makeMp3(text, "schedule");
						audio.change("schedule");
					}
	
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		
		frame.pack();
		
		// Mood page 달력 추가
		Calendar date = Calendar.getInstance();
		int year = date.get(Calendar.YEAR);
	    int month = date.get(Calendar.MONTH) + 1;
		
		selectMonthbtn.setText(Integer.toString(year));
		selectMonthbtn.setText(Integer.toString(month));
		selectMonthbtn.setBounds(1120, 22, 100, 46);
		selectMonthbtn.setBorderPainted(false);
		selectMonthbtn.setContentAreaFilled(false);
		MoodPanel.add(selectMonthbtn);
		
		selectMonthbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MakeSelectMonthFrame(80);
			}
		});

		selectMonthbtn.setFont(new Font("나눔고딕", Font.BOLD, 25));
		
	}
}

