package com.fileman.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainUI {

	public MainUI() throws FileNotFoundException, IOException {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = dim.width;
		int h = dim.height;
		JFrame frame = new JFrame("File Management System");
		frame.setBounds(w >> 2, h >> 2, w >> 1, h >> 1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		JPanel toolbar = new JPanel(new GridBagLayout());
		JLabel searchLabel = new JLabel("Key Word: ");
		searchLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		toolbar.add(searchLabel);
		JTextField input = new JTextField();
//		input.setBounds(input.getX(), input.getY(), 10, 10);
		toolbar.add(input);

//		UtilDateModel model = new UtilDateModel();
//		Properties prop = new Properties();
//		prop.put("text.today", "Today");
//		prop.put("text.month", "Month");
//		prop.put("text.year", "Year");
//		prop.put("text.clear", "Clear");
//		JDatePanelImpl datePanel = new JDatePanelImpl(model, prop);
//		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, null);
//		datePicker.getModel().setSelected(true);
//		datePicker.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (ActionEvent.ACTION_PERFORMED == e.getID()) {
//					datePicker.getModel().setSelected(true); 
//				}
//			}
//		});
//		 
//		toolbar.add(datePicker);

		JComboBox<String> cmb = new JComboBox<String>();
		cmb.addItem("--null--");
		cmb.addItem("身份证");
		cmb.addItem("驾驶证");
		cmb.addItem("军官证");
		toolbar.add(cmb);
		toolbar.add(new JButton("Search"));
		frame.add(toolbar, BorderLayout.NORTH);

		JTabbedPane tab = new JTabbedPane();
		frame.getContentPane().add(tab);

		JScrollPane scrollImport = new JScrollPane();
		tab.addTab("Data Import", scrollImport);

		JScrollPane scrollShow = new JScrollPane();
		tab.addTab("Data Show", scrollShow);
	}

}
