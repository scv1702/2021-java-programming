/*
 * 달력 생성 
 * 작성자: 이지현
 */

package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MakeSelectMonthFrame extends JFrame implements ItemListener, ActionListener {
    // 폰트 설정
    Font font = new Font("나눔고딕", Font.PLAIN, 20);

    // 상단
    JPanel selectPane = new JPanel();        // 패널 생성
    JButton prevMonthBtn = new JButton("◀");   // 이전 버튼
    JButton nextMonthBtn = new JButton("▶");   // 다음 버튼

    JComboBox<Integer> yearCombo = new JComboBox<Integer>(); //년도 콤보박스추가
	JComboBox<Integer> monthCombo = new JComboBox<Integer>(); //월 콤보박스 추가

    JLabel yearLB = new JLabel("년");        // "년" 라벨
    JLabel monthLB = new JLabel("월");       // "월" 라벨

    JPanel centerPane = new JPanel(new BorderLayout());
    JPanel titlePane = new JPanel(new GridLayout(1, 7));
    String[] title = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    JPanel dayPane = new JPanel(new GridLayout(0, 7));

    Calendar date;
    int year;
    int month;

    public MakeSelectMonthFrame(int heightSize) {
        super();
        date = Calendar.getInstance();
        year = date.get(Calendar.YEAR);
        month = date.get(Calendar.MONTH) + 1;

        // 창 세팅
        setSize(400, heightSize);
        setVisible(true);
		setResizable(false); // 사용자 창 크기 조절 방지
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // 배경색 흰색
        selectPane.setBackground(Color.WHITE);

        // 버튼 채우기 없음
        prevMonthBtn.setContentAreaFilled(false);
        nextMonthBtn.setContentAreaFilled(false);
        // 외곽선 삭제
        prevMonthBtn.setBorderPainted(false);
        nextMonthBtn.setBorderPainted(false);
        // 선택되었을 시 생기는 테두리 삭제
        prevMonthBtn.setFocusPainted(false);
        nextMonthBtn.setFocusPainted(false);

        // 콤보 박스 색상 흰색
        yearCombo.setBackground(Color.WHITE);
        monthCombo.setBackground(Color.WHITE);

        // 이전 달
        selectPane.add(prevMonthBtn);
        prevMonthBtn.setFont(font);

        // 년
        selectPane.add(yearCombo);
        yearCombo.setFont(font);
        selectPane.add(yearLB);
        yearLB.setFont(font);

        // 월
        selectPane.add(monthCombo);
        monthCombo.setFont(font);
        selectPane.add(monthLB);
        monthLB.setFont(font);
        
        // 다음 달
        selectPane.add(nextMonthBtn);
        nextMonthBtn.setFont(font);

        add(BorderLayout.NORTH, selectPane);

        // 현재 년, 월 세팅
        setYear();
        setMonth();

        setCalendarTitle();
        centerPane.add(BorderLayout.NORTH, titlePane);
        add(centerPane);

        centerPane.add(dayPane);
        setDay();

        prevMonthBtn.addActionListener(this);
        nextMonthBtn.addActionListener(this);

        yearCombo.addItemListener(this);
		monthCombo.addItemListener(this);
		
    }

    public void setDay() {
        date.set(year, month - 1, 1);
        int week = date.get(Calendar.DAY_OF_WEEK);
        int lastDay = date.getActualMaximum(Calendar.DATE);

        for(int i = 1; i < week; i++) {
            JLabel blankLb = new JLabel(" ");
            dayPane.add(blankLb);
        }

        for(int day = 1; day < lastDay; day++) {
            JLabel dayLb = new JLabel(String.valueOf(day), JLabel.CENTER);
            dayLb.setFont(font);

            date.set(Calendar.DATE, day);
            int w = date.get(Calendar.DAY_OF_WEEK);
            if (w == 1) {  // 일요일
                dayLb.setForeground(Color.red);
            }
            else if (w == 7) {  // 토요일
                dayLb.setForeground(Color.blue);
            }
            dayPane.add(dayLb);
        }
    }

    public void setCalendarTitle() {
        for(int i = 0; i < title.length; i++) {
            JLabel weekLb = new JLabel(title[i], JLabel.CENTER);
            weekLb.setFont(font);
            if(i == 0) {
                weekLb.setForeground(Color.red);
            }
            else if(i == 6) {
                weekLb.setForeground(Color.blue);
            }
            titlePane.add(weekLb);
        }
    }

    public void setYear() {
        for (int i = year - 20; i < year + 80; i++) {
            yearCombo.addItem(i);  // yearCombo 박스에 담음
        }
        yearCombo.setSelectedItem(year); // 이벤트와 연동 시켜주기 위함
    }

    public void setMonth() {
        for (int i = 1; i <= 12; i++) {
            monthCombo.addItem(i);
        }
        monthCombo.setSelectedItem(month); // 이벤트와 연동 시켜주기 위함
    }

    public void itemStateChanged(ItemEvent e) { 
		year = (int)yearCombo.getSelectedItem();
		month = (int)monthCombo.getSelectedItem();
		
		dayPane.setVisible(false);
		dayPane.removeAll();
		setDay();
		dayPane.setVisible(true);
	}

    @Override
    public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == prevMonthBtn) {
			prevMonth();
			setDayReset();
		}
        else if(obj == nextMonthBtn) {
			nextMonth(); 
			setDayReset();
		}
	}

	private void setDayReset() {
        yearCombo.removeItemListener(this);
		monthCombo.removeItemListener(this);
		
		yearCombo.setSelectedItem(year);
		monthCombo.setSelectedItem(month);
		
		dayPane.setVisible(false);
		dayPane.removeAll();
		setDay();
		dayPane.setVisible(true);
		
		yearCombo.addItemListener(this);
		monthCombo.addItemListener(this);
    }

    public void prevMonth() {
        if (month == 1) {
            year--;
            month = 12;
            setYear(year);
            setMonth(month);
        }
        else {
            month--;
            setMonth(month);
        }
    }

    public void nextMonth() {
        if(month == 12) {
            year++;
            month = 1;
            setYear(year);
            setMonth(month);
        }
        else {
            month++;
            setMonth(month);
        }
    }
    
    
    public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
    	return year;    	
    }
    
    public int getMonth() {
    	return month;
    }
}