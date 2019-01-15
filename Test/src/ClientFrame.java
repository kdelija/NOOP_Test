import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ClientFrame extends JFrame {

	private JPanel panel;
	private JPanel inputPanel;
	private JPanel dateTimePanel;
	private JPanel upperPanel;
	private JPanel timePanel;
	private JPanel datePanel;
	private JPanel bottunsPanel;
	
	private JTextField title;
	private JTextField place;
	private JTextField eventBeginning;
	private JTextField eventEnd;
	private JTextArea decription;
	private JTextArea txtArea;
	private JLabel titleLabel;
	private JLabel placeLabel;
	private JLabel descriptionLabel;
	private JLabel eventBeginningLabel;
	private JLabel eventEndLabel;
	
	// Combo boxes
	private JComboBox hour;
	private JComboBox minute;
	private JComboBox day;
	private JComboBox month;
	private JComboBox year;
	
	// Buttons
	private JButton createEvent;
	private JButton beginningTimeButton;
	private JButton endTimeButton;
	
	private JScrollPane scp;
	private PrintWriter pwr;
	private String msg;
	private String time;
	private String date;
	private static int clNum = 0;
	private DateFormat dateFormat;

	public ClientFrame() {

		initComps();
		layoutAll();
		activateChat();
		clNum++;
		this.setTitle("Client_" + clNum);
		setSize(600, 750);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	private void initComps() {
		
		// Jpanels
		panel = new JPanel(new BorderLayout());
		upperPanel = new JPanel(new BorderLayout());
		inputPanel = new JPanel(new GridBagLayout());
		dateTimePanel = new JPanel(new BorderLayout());
		timePanel = new JPanel(new FlowLayout());
		datePanel = new JPanel(new FlowLayout());
		bottunsPanel = new JPanel(new GridBagLayout());
		
		// Labels inputPanel
		titleLabel = new JLabel("Title:");
		placeLabel = new JLabel("Place:");
		descriptionLabel = new JLabel("Description:");
		eventBeginningLabel = new JLabel("Event beginning: time/date");
		eventEndLabel = new JLabel("Event end: time/date");
		
		
		// Components inputPanel
		title = new JTextField(20);
		place = new JTextField(20);
		eventBeginning = new JTextField(20);
		eventBeginning.setEnabled(false);
		eventEnd = new JTextField(20);
		eventEnd.setEnabled(false);
		decription = new JTextArea(5, 30);
		createEvent = new JButton("Create event");
		beginningTimeButton = new JButton("Set starting time");
		endTimeButton = new JButton("Set end time");
		hour = new JComboBox();
		minute = new JComboBox();
		day = new JComboBox();
		month = new JComboBox();
		year = new JComboBox();
		
		
		
	
		// Components dateTimePanel
		hour = new JComboBox<String>();
		DefaultComboBoxModel<String> hourModel = new DefaultComboBoxModel<String>();
		hourModel.addElement("hour");
		for(int i=1; i<=24;i++) {
			hourModel.addElement(Integer.toString(i) + "h");
		}
		hour.setModel(hourModel);
		
		minute = new JComboBox<String>();
		DefaultComboBoxModel<String> minuteModel = new DefaultComboBoxModel<String>();
		minuteModel.addElement("minute");
		for(int i=0; i<=60;i++) {
			minuteModel.addElement(Integer.toString(i) + "min");
		}
		minute.setModel(minuteModel);

		
		day = new JComboBox<String>();
		DefaultComboBoxModel<String> dayModel = new DefaultComboBoxModel<String>();
		dayModel.addElement("day");
		for(int i=1; i<=31;i++) {
			dayModel.addElement(Integer.toString(i) + "d");
		}
		day.setModel(dayModel);

		
		month = new JComboBox<String>();
		DefaultComboBoxModel<String> monthModel = new DefaultComboBoxModel<String>();
		monthModel.addElement("month");
		for(int i=1; i<=12;i++) {
			monthModel.addElement(Integer.toString(i) + "m");
		}
		month.setModel(monthModel);

		
		year = new JComboBox<String>();
		DefaultComboBoxModel<String> yearModel = new DefaultComboBoxModel<String>();
		yearModel.addElement("year");
		for(int i=1990; i<=2030;i++) {
			yearModel.addElement(Integer.toString(i) + "y");
		}
		year.setModel(yearModel);

		
		
		
		
		// // Components scp
		txtArea = new JTextArea();
		txtArea.setEditable(false);
		txtArea.setLineWrap(true);
		scp = new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Borders for panels
		Border mainBorder = BorderFactory.createEtchedBorder();
		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border inner = BorderFactory.createTitledBorder("Event creator");
		Border inner2 = BorderFactory.createTitledBorder("Chose time and date");


		panel.setBorder(mainBorder);
		inputPanel.setBorder(BorderFactory.createCompoundBorder(outer, inner));
		
		dateTimePanel.setBorder(BorderFactory.createCompoundBorder(outer, inner2));
	}

	private void layoutAll() {

		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		
		gbc.gridx = 0;
		gbc.gridy = 0;

		
		gbc.anchor = GridBagConstraints.PAGE_START;
		inputPanel.add(titleLabel, gbc);
		
		gbc.gridy = 1;
//
		gbc.anchor = GridBagConstraints.CENTER;
		inputPanel.add(title, gbc);
		
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.PAGE_START;
		inputPanel.add(placeLabel, gbc);
		
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		inputPanel.add(place, gbc);
		
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.PAGE_START;
		inputPanel.add(eventBeginningLabel, gbc);
		
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.CENTER;
		inputPanel.add(eventBeginning, gbc);
		
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.CENTER;
		inputPanel.add(eventEndLabel, gbc);
		
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.PAGE_START;
		inputPanel.add(eventEnd, gbc);
		
		
		// Second row
		
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		
		gbc.anchor = GridBagConstraints.PAGE_START;
		inputPanel.add(descriptionLabel, gbc);
		
		gbc.gridy = 1;
		gbc.gridheight = 4;
		gbc.fill = GridBagConstraints.VERTICAL;

		gbc.anchor = GridBagConstraints.CENTER;
		inputPanel.add(decription, gbc);
		
		gbc.gridy = 6;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.PAGE_END;
		inputPanel.add(createEvent, gbc);

		
		
		// dateTimePanel layout
		timePanel.add(hour);
		timePanel.add(minute);
		
		datePanel.add(day);
		datePanel.add(month);
		datePanel.add(year);
		
		
		
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.weightx = 1;
		gbc1.weighty = 0.25;
		
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		gbc1.anchor = GridBagConstraints.LINE_START;
		bottunsPanel.add(beginningTimeButton, gbc1);
		
		gbc1.gridy = 1;
		gbc1.fill = GridBagConstraints.HORIZONTAL;
		gbc1.anchor = GridBagConstraints.LINE_START;
		bottunsPanel.add(endTimeButton, gbc1);


		
		
		dateTimePanel.add(timePanel, BorderLayout.LINE_START);
		dateTimePanel.add(datePanel, BorderLayout.CENTER);
		dateTimePanel.add(bottunsPanel, BorderLayout.LINE_END);

		upperPanel.add(scp, BorderLayout.CENTER);
		upperPanel.add(dateTimePanel, BorderLayout.SOUTH);
		panel.add(upperPanel, BorderLayout.CENTER);
		panel.add(inputPanel, BorderLayout.SOUTH);
		this.setLayout(new BorderLayout());
		this.add(panel);
	}

	public void writeReceivedMessage(String msg) {
		txtArea.append(msg);
		txtArea.append("\n");
	}

	public void activateChat() {
		

		createEvent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				
				
				if(!title.getText().equals("") && !place.getText().equals("") && !decription.getText().equals("")&& !eventBeginning.getText().equals("")&& !eventEnd.getText().equals("")) {
					
					msg = ("Event title: " + title.getText() + "\nEvent place: " + place.getText() + "\nEvent description: " + decription.getText() + "\nBeginning of the event: " + eventBeginning.getText() + "\nEnd of the event: " + eventEnd.getText()); 
					pwr.println("*************************************");
					pwr.println("Created: " + dateFormat.format(cal.getTime()));
					pwr.println(msg);
					pwr.println("*************************************");
					pwr.flush();
					title.setText("");
					place.setText("");
					decription.setText("");
					eventBeginning.setText("");
					eventEnd.setText("");
					eventBeginning.setEnabled(false);
					eventEnd.setEnabled(false);
					title.requestFocus();
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Morate ispuniti sva polja prije kreiranja eventa");
				}
				

			}
		});
		
		beginningTimeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				time = (hour.getSelectedIndex() + ":" + minute.getSelectedItem() + "   " + day.getSelectedIndex() + "/" + month.getSelectedIndex() + "/" + year.getSelectedItem());
				eventBeginning.setEnabled(true);
				eventBeginning.setText(time);
			}
		});
		
		endTimeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				date = (hour.getSelectedIndex() + ":" + minute.getSelectedItem() + "   " + day.getSelectedIndex() + "/" + month.getSelectedIndex() + "/" + year.getSelectedItem());
				eventEnd.setEnabled(true);
				eventEnd.setText(date);
			}
		});

	}

	public String getMessage() {

		return msg;
	}

	public void setPrintWriter(PrintWriter writer) {
		this.pwr = writer;
	}

	public void writeTxt(String string) {
		txtArea.append("******************************************\n");
		txtArea.append(string);
		txtArea.append("\n");
		txtArea.append("******************************************\n");
	}

}