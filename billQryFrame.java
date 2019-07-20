package com.nuist.sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class billQryFrame extends JFrame {

	private JPanel contentPane;
	private JTextField year;
	DefaultTableModel dm = new DefaultTableModel();
    JScrollPane scrollPane = new JScrollPane();
    private JTable RKBTable = new JTable(dm);
    private JTextField money;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					billQryFrame frame = new billQryFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public JTable getJTable(Date time){
		  XSBDao dao = new XSBDao();
		  List<XSBModel>list = dao.selectXSY(time);
		  int n = list.size();
		  Object[][]data=new Object[n][8];
		  String[] ColName={"图书号","书名","数量"};
		  int i=0;float zonghe=0;
		  for(XSBModel XS:list){
			  data[i][0]=XS.getBh();
			  data[i][1]=XS.getSm();
			  data[i][2]=XS.getSl();
			  zonghe+=XS.getSum();
			  i++;
		  }
		  RKBTable.setModel(new DefaultTableModel(data,ColName));
		  money.setText(String.valueOf(zonghe));
		  return RKBTable;
	  }
	public JTable getJTable1(Date time){
		  XSBDao dao = new XSBDao();
		  List<XSBModel>list = dao.selectCX(time);
		  int n = list.size();
		  Object[][]data=new Object[n][8];
		  String[] ColName={"图书号","书名","月销量"};
		  int i=0;
		  for(XSBModel XS:list){
			  data[i][0]=XS.getBh();
			  data[i][1]=XS.getSm();
			  data[i][2]=XS.getYx();
			  i++;
		  }
		  RKBTable.setModel(new DefaultTableModel(data,ColName));
		  return RKBTable;
	  }
	
	/**
	 * Create the frame.
	 */
	public billQryFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("查询订单");
		this.setVisible(true);
		JLabel label = new JLabel("\u5E74");
		label.setBounds(94, 16, 15, 18);
		contentPane.add(label);
		
		String[] yue = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		JComboBox month = new JComboBox(yue);
		month.setBounds(116, 13, 50, 24);
		contentPane.add(month);
		
		JLabel label_1 = new JLabel("\u6708");
		label_1.setBounds(173, 16, 22, 18);
		contentPane.add(label_1);
		
		JButton csButton = new JButton("\u67E5\u8BE2");
		csButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StringBuilder time = new StringBuilder();
				time.append(year.getText()).append("-").append(month.getSelectedItem().toString());
				SimpleDateFormat m = new SimpleDateFormat("yyyy-MM");
				Date rq = null;
				try {
					rq = m.parse(time.toString());
				} catch (ParseException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "请按格式输入日期","错误",JOptionPane.ERROR_MESSAGE);
				}
				RKBTable = getJTable(rq);	
			}
		});
		csButton.setBounds(197, 12, 89, 27);
		contentPane.add(csButton);
		
		JButton BestSailer = new JButton("\u6708\u7545\u9500\u4E66\u5355");
		BestSailer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StringBuilder time = new StringBuilder();
				time.append(year.getText()).append("-").append(month.getSelectedItem().toString());
				SimpleDateFormat m = new SimpleDateFormat("yyyy-MM");
				Date rq = null;
				try {
					rq = m.parse(time.toString());
				} catch (ParseException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "请按格式输入日期","错误",JOptionPane.ERROR_MESSAGE);
				}
				RKBTable = getJTable1(rq);	
			}
				
				
				
			
		});
		BestSailer.setBounds(292, 12, 113, 27);
		contentPane.add(BestSailer);
		
		scrollPane.setViewportView(RKBTable);
		scrollPane.setBounds(14, 50, 391, 167);
		contentPane.add(scrollPane);
		
		year = new JTextField();
		year.setBounds(14, 13, 75, 24);
		contentPane.add(year);
		year.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6708\u9500\u552E\u989D");
		label_2.setBounds(262, 230, 60, 18);
		contentPane.add(label_2);
		
		money = new JTextField();
		money.setEnabled(false);
		money.setBounds(324, 227, 81, 24);
		contentPane.add(money);
		money.setColumns(10);
	}
}
