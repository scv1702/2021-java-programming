/*
 * �޷� ���� 
 * �ۼ���: ������
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
	// ��Ʈ ����
	Font font = new Font("�������", Font.PLAIN, 20);

	// ���
	JPanel selectPane = new JPanel(); // �г� ����
	JButton prevMonthBtn = new JButton("��"); // ���� ��ư
	JButton nextMonthBtn = new JButton("��"); // ���� ��ư

	JComboBox<Integer> yearCombo = new JComboBox<Integer>(); // �⵵ �޺��ڽ��߰�
	JComboBox<Integer> monthCombo = new JComboBox<Integer>(); // �� �޺��ڽ� �߰�

	JLabel yearLB = new JLabel("��"); // "��" ��
	JLabel monthLB = new JLabel("��"); // "��" ��

	JPanel centerPane = new JPanel(new BorderLayout());
	JPanel titlePane = new JPanel(new GridLayout(1, 7));
	String[] title = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
	JPanel dayPane = new JPanel(new GridLayout(0, 7));

	Calendar date;
	int year;
	int month;

	public MakeSelectMonthFrame(int heightSize) {
		super();
		date = Calendar.getInstance();
		year = date.get(Calendar.YEAR);
		month = date.get(Calendar.MONTH) + 1;

		// â ����
		setSize(400, heightSize);
		setVisible(true);
		// setResizable(false); // ����� â ũ�� ���� ����
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// ���� ���
		selectPane.setBackground(Color.WHITE);

		// ��ư ä��� ����
		prevMonthBtn.setContentAreaFilled(false);
		nextMonthBtn.setContentAreaFilled(false);
		// �ܰ��� ����
		prevMonthBtn.setBorderPainted(false);
		nextMonthBtn.setBorderPainted(false);
		// ���õǾ��� �� ����� �׵θ� ����
		prevMonthBtn.setFocusPainted(false);
		nextMonthBtn.setFocusPainted(false);

		// �޺� �ڽ� ���� ���
		yearCombo.setBackground(Color.WHITE);
		monthCombo.setBackground(Color.WHITE);

		// ���� ��
		selectPane.add(prevMonthBtn);
		prevMonthBtn.setFont(font);

		// ��
		selectPane.add(yearCombo);
		yearCombo.setFont(font);
		selectPane.add(yearLB);
		yearLB.setFont(font);

		// ��
		selectPane.add(monthCombo);
		monthCombo.setFont(font);
		selectPane.add(monthLB);
		monthLB.setFont(font);

		// ���� ��
		selectPane.add(nextMonthBtn);
		nextMonthBtn.setFont(font);

		add(BorderLayout.NORTH, selectPane);

		// ���� ��, �� ����
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

		for (int i = 1; i < week; i++) {
			JLabel blankLb = new JLabel(" ");
			dayPane.add(blankLb);
		}

		for (int day = 1; day < lastDay; day++) {
			JLabel dayLb = new JLabel(String.valueOf(day), JLabel.CENTER);
			dayLb.setFont(font);

			date.set(Calendar.DATE, day);
			int w = date.get(Calendar.DAY_OF_WEEK);
			if (w == 1) { // �Ͽ���
				dayLb.setForeground(Color.red);
			} else if (w == 7) { // �����
				dayLb.setForeground(Color.blue);
			}
			dayPane.add(dayLb);
		}
	}

	public void setCalendarTitle() {
		for (int i = 0; i < title.length; i++) {
			JLabel weekLb = new JLabel(title[i], JLabel.CENTER);
			weekLb.setFont(font);
			if (i == 0) {
				weekLb.setForeground(Color.red);
			} else if (i == 6) {
				weekLb.setForeground(Color.blue);
			}
			titlePane.add(weekLb);
		}
	}

	public void setYear() {
		for (int i = year - 20; i < year + 80; i++) {
			yearCombo.addItem(i); // yearCombo �ڽ��� ����
		}
		yearCombo.setSelectedItem(year); // �̺�Ʈ�� ���� �����ֱ� ����
	}

	public void setMonth() {
		for (int i = 1; i <= 12; i++) {
			monthCombo.addItem(i);
		}
		monthCombo.setSelectedItem(month); // �̺�Ʈ�� ���� �����ֱ� ����
	}

	public void itemStateChanged(ItemEvent e) {
		year = (int) yearCombo.getSelectedItem();
		month = (int) monthCombo.getSelectedItem();

		dayPane.setVisible(false);
		dayPane.removeAll();
		setDay();
		dayPane.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if (obj == prevMonthBtn) {
			prevMonth();
			setDayReset();
		} else if (obj == nextMonthBtn) {
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
		} else {
			month--;
			setMonth(month);
		}
	}

	public void nextMonth() {
		if (month == 12) {
			year++;
			month = 1;
			setYear(year);
			setMonth(month);
		} else {
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